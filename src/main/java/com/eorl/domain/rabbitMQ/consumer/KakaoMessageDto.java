package com.eorl.domain.rabbitMQ.consumer;

import lombok.Data;

@Data
public class KakaoMessageDto {
    private String objType;
    private String text;
    private String webUrl;
    private String mobileUrl;
    private String btnTitle;
}
