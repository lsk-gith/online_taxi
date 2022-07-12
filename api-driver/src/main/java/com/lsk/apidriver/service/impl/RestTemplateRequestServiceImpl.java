package com.lsk.apidriver.service.impl;

import com.lsk.apidriver.constant.HttpUrlConstants;
import com.lsk.apidriver.service.RestTemplateRequestService;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.sms.SmsSendRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 14:54
 * @Description: com.lsk.apidriver.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
public class RestTemplateRequestServiceImpl implements RestTemplateRequestService {
    @Resource
    private RestTemplate restTemplate;


    @Override
    public ResponseResult smsSend(SmsSendRequest smsSendRequest) {
        String url = HttpUrlConstants.SERVICE_SMS_URL + "/send/alisms-template";
        return restTemplate.postForEntity(url, smsSendRequest, ResponseResult.class).getBody();
    }

    @Override
    public String grabOrder(int orderId, int driverId) {
        //又调用了一个服务
        //"http://service-order/grab/do/orderId?driverId=driverId"
        String url = HttpUrlConstants.SERVICE_ORDER_URL + "/grab/do/"+orderId+"?driverId="+driverId;
        return restTemplate.getForEntity(url,String.class).getBody();
    }
    private ResponseResult sendFail(SmsSendRequest smsSendRequest, Throwable throwable){
        log.info("异常信息：" + throwable);
        return ResponseResult.fail(-3, "restTemplate熔断");
    }
}
