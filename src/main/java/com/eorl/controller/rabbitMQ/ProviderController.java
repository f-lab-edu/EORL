package com.eorl.controller.rabbitMQ;

import com.eorl.domain.notification.Notification;
import com.eorl.service.notification.NotificationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/rabbit/provider")
@RequiredArgsConstructor
@Validated
public class ProviderController {

    @Value("${rabbitmq.exchange.name}")
    private String EXCHANGE_NAME;
    @Value("${rabbitmq.routing.key}")
    private String ROUTING_KEY;

    @Autowired
    RabbitTemplate rabbitTemplate;


    private final NotificationService notificationService;


    /**
     * Message 를 Message Broker 로 보낸다.
     */
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @GetMapping()
    public void providerMessage(Pageable pageable) {
        Page<Notification> allNotification = notificationService.findAllOrderByNotificationId(
                pageable);
        List<Notification> content = allNotification.getContent();
        for (Notification notification : content) {
            rabbitTemplate.convertAndSend(EXCHANGE_NAME,ROUTING_KEY,notification);
        }

    }
}
