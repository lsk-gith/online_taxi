package com.lsk.apidriver.service;

import com.lsk.common.dto.ResponseResult;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 14:01
 * @Description: com.lsk.apidriver.service
 * @version: 1.0
 */
public interface ShortMsgService {
    ResponseResult send(String phoneNumber, String code);
}
