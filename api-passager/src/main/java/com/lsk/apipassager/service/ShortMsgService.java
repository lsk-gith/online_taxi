package com.lsk.apipassager.service;

import com.lsk.common.dto.ResponseResult;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 20:48
 * @Description: com.lsk.apipassager.service
 * @version: 1.0
 */
public interface ShortMsgService {
    /**
     * 发送验证码
     * @param phonenumber
     * @param code
     * @return
     */
    public abstract ResponseResult send(String phonenumber, String code);
}
