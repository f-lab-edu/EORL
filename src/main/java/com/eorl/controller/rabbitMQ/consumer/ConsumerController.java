package com.eorl.controller.rabbitMQ.consumer;

import com.eorl.service.kakao.KakaoMessageAuthService;
import com.eorl.service.kakao.KakaoMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerController {


    @RabbitListener(queues = "sample.queue")
    public void receiveMessage(final Message message) {
        log.info("CONSUMER receive : {}" , message.toString());
    }

    @Autowired
    KakaoMessageAuthService kakaoMessageAuthService;

    @Autowired
    KakaoMessageService kakaoMessageService;

    @RabbitListener(queues = "eorl.kakao.queue")
    public void receiveMessageKakao(final Message message) {

        //code값은 kakao 로그인 후 받아오는 값
        String code = "";

        if(kakaoMessageAuthService.getKakaoAuthToken(code)) {
            kakaoMessageService.sendMyMessage();
            log.info("메시지 전송");
        }else {
            log.error("메시지 전송 실패");
        }
    }


}
