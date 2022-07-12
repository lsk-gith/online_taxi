package com.lsk.common.dto.sms;

import lombok.Data;

import java.util.Map;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 14:41
 * @Description: com.lsk.common.dto.sms
 * @version: 1.0
 */
@Data
public class SmsTemplateDto {
    private String id;
    private Map<String, Object> templateMap;
    @Override
    public String toString(){
        return "SmsTemplateDto [id=" + id + ", templateMap=" + templateMap + "]";
    }
}
