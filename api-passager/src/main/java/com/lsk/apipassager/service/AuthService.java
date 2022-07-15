package com.lsk.apipassager.service;

import com.lsk.common.dto.ResponseResult;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:07
 * @Description: com.lsk.apipassager.service
 * @version: 1.0
 */
public interface AuthService {

    public abstract ResponseResult auth(String passengerPhone, String code);

}
