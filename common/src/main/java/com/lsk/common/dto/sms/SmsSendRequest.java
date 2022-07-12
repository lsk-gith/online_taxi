package com.lsk.common.dto.sms;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 14:40
 * @Description: com.lsk.common.dto.sms
 * @version: 1.0
 */
@Data
public class SmsSendRequest {
    private String[] receivers;
    private List<SmsTemplateDto> data;

    @Override
    public String toString(){
        return "SmsSendRequest [reveivers=" + Arrays.toString(receivers) + ", data=" + data + "]";
    }
}
