package com.lsk.apipassager.service;

import com.lsk.common.dto.order.ForecastRequest;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 21:11
 * @Description: com.lsk.apipassager.service
 * @version: 1.0
 */
public interface OrderService {
    /**
     * 根据起止经纬度计算预估价格
     * @param forecastRequest
     * @return
     */
    public abstract double forcast(ForecastRequest forecastRequest);

}
