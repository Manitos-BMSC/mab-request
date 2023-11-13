package bo.edu.ucb.mabrequest.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public TopicExchange requestExchange() {
        return new TopicExchange("request-exchange", true, true);
    }

    @Bean
    public Queue requestAcceptedQueue() {
        return QueueBuilder.durable("accepted.request.queue").build();
    }
    @Bean
    public Queue requestRejectedQueue() {
        return QueueBuilder.durable("rejected.request.queue").build();
    }

    @Bean
    public Binding requestAcceptedBinding(TopicExchange requestExchange, Queue requestAcceptedQueue) {
        return BindingBuilder
                .bind(requestAcceptedQueue)
                .to(requestExchange)
                .with("accepted.#");
    }

    @Bean
    public Binding requestRejectedBinding(TopicExchange requestExchange, Queue requestRejectedQueue) {
        return BindingBuilder
                .bind(requestRejectedQueue)
                .to(requestExchange)
                .with("rejected.#");
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;

    }
}
