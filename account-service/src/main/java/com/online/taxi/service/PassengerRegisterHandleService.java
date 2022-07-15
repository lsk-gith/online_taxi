package com.online.taxi.service;

import com.online.taxi.request.GetTokenRequest;
import com.online.taxi.dto.ResponseResult;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 17:49
 * @Description: com.online.taxi.accountservice.service
 * @version: 1.0
 */
public interface PassengerRegisterHandleService {

    public abstract ResponseResult handle(GetTokenRequest getTokenRequest);

    public abstract ResponseResult checkOut(GetTokenRequest request) throws Exception;
}
