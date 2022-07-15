package com.lsk.apipassager.feign.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:11
 * @Description: com.lsk.apipassager.feign.request
 * @version: 1.0
 */
@Data
public class CodeVerifyRequest {

    private int identity;

    private String phoneNumber;

    private String code;
}
