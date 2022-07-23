package com.online.taxi.dto.sms;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 15:50
 * @Description: com.online.taxi.dto.sms
 * @version: 1.0
 */
@Data
public class SmsRequest {
    /**
     * 模板ID
     */
    private String templateId;

    /**
     * 手机号
     */
    private String[] phones;

    /**
     * 替换内容
     */
    private String[] content;
}
