package com.lsk.apipassager.feign;

import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.order.ForecastRequest;
import com.lsk.common.dto.order.ForecastResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 22:43
 * @Description: com.lsk.apipassager.service
 * @version: 1.0
 */
@FeignClient(name = "service-valuation")
public interface ServiceForecast {
    @RequestMapping(value = "/forecast/single",method = RequestMethod.POST)
    public abstract ResponseResult<ForecastResponse> forecast(@RequestBody ForecastRequest forecastRequest);

}
