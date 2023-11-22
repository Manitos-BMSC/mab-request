package bo.edu.ucb.mabrequest;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MabRequestApplication {

	@Bean
	public ApplicationRunner runner(ConnectionFactory connectionFactory ) {
		return ApplicationRunner -> {
			var open = false;
			while (!open) {
				try {
					connectionFactory.createConnection().close();
					open = true;
				} catch (Exception e) {
					System.out.println("Waiting for RabbitMQ");
				}
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MabRequestApplication.class, args);
	}

}
