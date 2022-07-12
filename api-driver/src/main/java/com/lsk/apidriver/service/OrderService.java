package com.lsk.apidriver.service;

import com.lsk.common.dto.order.ForecastRequest;
import com.lsk.common.dto.order.ForecastResponse;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 15:37
 * @Description: com.lsk.apidriver.service
 * @version: 1.0
 */
public interface OrderService {
    /*
     * 根据起止经纬度计算预估价格
     * @param forecastRequest
     * @return
     */
    ForecastResponse forecast(ForecastRequest forecastRequest);
}
