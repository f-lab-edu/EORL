package com.eorl.domain.rabbitMQ.consumer;

import lombok.Data;

//사업장 인증 해야 비즈 알림톡 전송 가능하여 Deprecated 처리
@Deprecated
@Data
public class KakaoMessageDto {
    private String objType;
    private String text;
    private String webUrl;
    private String mobileUrl;
    private String btnTitle;
}
