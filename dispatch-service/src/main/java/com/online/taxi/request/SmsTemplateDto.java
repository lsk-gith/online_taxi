package com.online.taxi.request;

import lombok.Data;

import java.util.Map;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 11:43
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class SmsTemplateDto {
    private String id;

    private Map<String, Object> templateMap;

    @Override
    public String toString() {
        return "SmsTemplateDto [id=" + id + ", templateMap=" + templateMap + "]";
    }

}
