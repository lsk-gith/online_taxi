package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.OrderDtoRequest;

/**
 * @Auther: lsk
 * @Date: 2022/7/30 - 07 - 30 - 17:48
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface OrderGrabService {
    /**
     * 司机抢单
     * @param orderRequest
     * @return
     * @throws Exception
     */
    ResponseResult grab(OrderDtoRequest orderRequest) throws Exception;

}
