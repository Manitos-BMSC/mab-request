package bo.edu.ucb.mabrequest.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class GlobalSecurityConfiguration {

    private final KeycloakJwtTokenConverter keycloakJwtTokenConverter;

    private final Logger logger = LoggerFactory.getLogger(GlobalSecurityConfiguration.class);

    /*@Value("#{${security-constraints}}")
    private List<SecurityConstraint> securityConstraints;*/
    public GlobalSecurityConfiguration(TokenConverterProperties properties) {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter
                = new JwtGrantedAuthoritiesConverter();
        this.keycloakJwtTokenConverter
                = new KeycloakJwtTokenConverter(
                jwtGrantedAuthoritiesConverter,
                properties);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       SecurityCollection securityCollection = new SecurityCollection();

       securityCollection.setName("prueba");
         securityCollection.setPatterns(Arrays.asList("/api/v1/request"));
            securityCollection.setMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        SecurityConstraint securityConstraint = new SecurityConstraint();
        securityConstraint.setAuthRoles(Arrays.asList("doctorJefe", "doctor"));
        securityConstraint.setSecurityCollections(Arrays.asList(securityCollection));

        SecurityCollection cycle = new SecurityCollection();

        cycle.setName("cycle");
        cycle.setPatterns(Arrays.asList("/api/v1/cycle"));
        cycle.setMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));


        SecurityConstraint securityConstraintCycle = new SecurityConstraint();
        securityConstraintCycle.setAuthRoles(Arrays.asList("permitAll"));
        securityConstraintCycle.setSecurityCollections(Arrays.asList(cycle));

        List<SecurityConstraint> securityConstraints = new ArrayList<>();
        securityConstraints.add(securityConstraintCycle);

        http.authorizeHttpRequests( (authorizeHttpRequests) -> {
            securityConstraints.forEach( (constraint) -> {
                logger.info("constraint: " + constraint);
                try {
                    List<String> authRoles = constraint.getAuthRoles();
                    List<SecurityCollection> securityCollections = constraint.getSecurityCollections();

                    securityCollections.forEach(collection -> {
                        String name = collection.getName();
                        List<String> patterns = collection.getPatterns();
                        List<String> methods = collection.getMethods();

                        List<HttpMethod> httpMethods = new ArrayList<>();

                        for (String method: methods
                             ) {
                            switch (method) {
                                case "GET":
                                    httpMethods.add(HttpMethod.GET);
                                    break;
                                case "POST":
                                    httpMethods.add(HttpMethod.POST);
                                    break;
                                case "PUT":
                                    httpMethods.add(HttpMethod.PUT);
                                    break;
                                case "DELETE":
                                    httpMethods.add(HttpMethod.DELETE);
                                    break;
                                case "PATCH":
                                    httpMethods.add(HttpMethod.PATCH);
                                    break;
                                default:
                                    break;
                            }
                        }

                        AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry response = null;

                        if (httpMethods.isEmpty()) {
                            response = authorizeHttpRequests
                                    .requestMatchers(patterns.toArray(new String[0]))
                                    .hasAnyRole(authRoles.toArray(new String[0]));
                        }else{
                            if (authRoles.size() == 1) {
                                String role = authRoles.get(0);
                                if (role.equals("permitAll")) {
                                    response = authorizeHttpRequests
                                            .requestMatchers(patterns.toArray(new String[0]))
                                            .permitAll();
                                }
                            }else{
                                for (HttpMethod httpMethod: httpMethods
                                ) {
                                   response = authorizeHttpRequests
                                            .requestMatchers(httpMethod, patterns.toArray(new String[0]))
                                            .hasAnyRole(authRoles.toArray(new String[0]));
                                }
                            }
                        }

                        response.anyRequest().denyAll();

                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            /*authorizeHttpRequests
                    .requestMatchers("/api/v1/registry/patient").permitAll()
                    .requestMatchers("/api/v1/country-cities").permitAll()
                    .requestMatchers("/api/v1/request").hasAnyRole("doctorJefe", "doctor")
                    .requestMatchers("api/v1/doctor/assign/**").hasRole("doctorJefe")
                    .requestMatchers("/api/v1/doctor/**").hasAnyRole("doctorJefe", "doctor")
                    .requestMatchers("/api/v1/cycle").hasRole("doctorJefe")
                    .anyRequest()
                    .denyAll();*/
        });
        http.oauth2ResourceServer( (oauth2) -> {
            oauth2.jwt( (jwt) -> jwt.jwtAuthenticationConverter(keycloakJwtTokenConverter));
        });
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}