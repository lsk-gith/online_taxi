package com.lsk.apipassager.controller;

import com.lsk.apipassager.feign.ServiceForecast;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.order.ForecastRequest;
import com.lsk.common.dto.order.ForecastResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 22:41
 * @Description: com.lsk.apipassager.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private ServiceForecast serviceForecast;

    public ResponseResult<ForecastResponse> forecast(@RequestBody ForecastRequest forecastRequest){
        ResponseResult<ForecastResponse> result = serviceForecast.forecast(forecastRequest);
        return ResponseResult.success(result.getData());
    }

    /*
     * 下面是演示两种调用方式
     */
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/forecast-test")
    public ResponseResult forecastTest(@RequestBody ForecastRequest forecastRequest){
        /*
         * 具体ip(localhost:8060)，不加LoadBalanced
         * 服务名(service-valuation)，加LoadBalanced
         */
//		String destination = "localhost:8060";
        String destination = "service-valuation";

        String url = "http://"+destination+"/forecast/single";
        HttpHeaders headers = new HttpHeaders();

        JSONObject requestParam = new JSONObject();
        requestParam.put("startLatitude", "1");
        requestParam.put("startLongitude", "1");
        requestParam.put("endLatitude", "1");
        requestParam.put("endLongitude", "1");
        HttpEntity httpEntity = new HttpEntity(requestParam, headers);
        ResponseResult result = restTemplate.exchange(url, HttpMethod.POST,httpEntity,ResponseResult.class).getBody();
        return ResponseResult.success(result.getData());
    }


}
