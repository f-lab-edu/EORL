package com.eorl.service.kakao;

import com.eorl.domain.rabbitMQ.consumer.KakaoMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//사업장 인증 해야 비즈 알림톡 전송 가능하여 Deprecated 처리
@Deprecated
@Service
public class KakaoMessageService {

    @Autowired
    KakaoMessageSendService messageService;

    public boolean sendMyMessage() {
        KakaoMessageDto myMsg = new KakaoMessageDto();
        myMsg.setBtnTitle("자세히보기");
        myMsg.setMobileUrl("");
        myMsg.setObjType("text");
        myMsg.setWebUrl("");
        myMsg.setText("메시지 테스트입니다.");

        String accessToken = KakaoMessageAuthService.authToken;

        return messageService.sendMessage(accessToken, myMsg);
    }
}
