package bo.edu.ucb.mabrequest.Service;

import jakarta.ws.rs.FormParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Map;

@Service
@FeignClient(url = "http://192.241.149.226:8080" , value = "mab-keycloak")
public interface KeycloakTokenService {

    @PostMapping(value = "/realms/mab-manitos/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Map<String, ?> getToken(
           @RequestPart("grant_type") String grant_type,
           @RequestPart("client_id") String client_id,
           @RequestPart("client_secret") String client_secret
    );

}
