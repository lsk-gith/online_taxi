package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.GetTokenRequest;

/**
 * @Auther: lsk
 * @Date: 2022/7/18 - 07 - 18 - 22:20
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface DriverRegistHandleService {

    public abstract ResponseResult checkIn(GetTokenRequest request);
}
