package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 22:26
 * @Description: com.online.taxi.accountservice.request
 * @version: 1.0
 */
@Data
public class CreateTokenRequest {
    private int type;

    private String phoneNum;

    private int id;
}
