package com.lsk.apidriver.service;

import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.sms.SmsSendRequest;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 14:38
 * @Description: com.lsk.apidriver.service
 * @version: 1.0
 */
public interface RestTemplateRequestService {

    ResponseResult smsSend(SmsSendRequest smsSendRequest);

    String grabOrder(int orderId, int driverId);

}
