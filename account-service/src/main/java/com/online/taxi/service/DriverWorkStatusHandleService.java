package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.DriverWorkStatusRequest;

/**
 * @Auther: lsk
 * @Date: 2022/7/18 - 07 - 18 - 22:45
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface DriverWorkStatusHandleService {
    ResponseResult changeWorkStatus(DriverWorkStatusRequest driverWorkStatusRequest);
}
