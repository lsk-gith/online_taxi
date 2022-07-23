package com.online.taxi.request;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 11:43
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class SmsSendRequest {
    private String[] receivers;
    private List<SmsTemplateDto> data;

    @Override
    public String toString() {
        return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
    }
}
