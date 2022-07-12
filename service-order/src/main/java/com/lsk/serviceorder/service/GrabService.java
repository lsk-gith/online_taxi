package com.lsk.serviceorder.service;

import com.lsk.common.dto.ResponseResult;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:45
 * @Description: com.lsk.serviceorder.service
 * @version: 1.0
 */
public interface GrabService {
    /**
     * 司机抢单
     * @param orderId
     * @param driverId
     * @return
     */
    public abstract ResponseResult grabOrder(int orderId, int driverId);
}
