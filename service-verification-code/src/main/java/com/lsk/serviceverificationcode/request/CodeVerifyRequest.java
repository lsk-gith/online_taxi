package com.lsk.serviceverificationcode.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 21:35
 * @Description: com.lsk.serviceverificationcode.request
 * @version: 1.0
 */
@Data
public class CodeVerifyRequest {
    private int identity;

    private String phoneNumber;

    private String code;
}
