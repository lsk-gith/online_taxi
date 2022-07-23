package com.online.taxi.dto.push;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 17:01
 * @Description: com.online.taxi.dto.push
 * @version: 1.0
 */
@Data
public class PushRequest {

    private String sendId;

    private Integer sendIdentity;

    private int acceptIdentity ;

    private String acceptId;

    private int messageType;

    private String title;

    private String messageBody;

    private Integer messageChannel;

    private String businessMessage;

    private Integer businessType;

    public PushRequest() {
    }
}
