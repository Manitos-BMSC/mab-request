package bo.edu.ucb.mabrequest.producer;

import bo.edu.ucb.mabrequest.Dto.RequestDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NotificationProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    Logger logger = Logger.getLogger(NotificationProducer.class.getName());

    public String sendAcceptedNotification(RequestDto requestDto, String routingKey) {
        logger.info("Sending accepted notification...");
        amqpTemplate.convertAndSend("request-exchange", routingKey, requestDto);
        return "Accepted notification sent";
    }
}
