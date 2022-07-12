package com.lsk.serviceverificationcode.service;

import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.verficationcode.VerifyCodeResponse;

/**
 * @Auther: lsk
 * @Date: 2022/7/11 - 07 - 11 - 22:39
 * @Description: com.lsk.serviceverificationcode.service
 * @version: 1.0
 */
public interface VerifyCodeService {
    /**
     * 根据身份和手机号生成验证码
     * @param identity
     * @param phoneNumber
     * @return
     */
    public abstract ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);

    /**
     * 校验身份，手机号，验证码的合法性
     * @param identity
     * @param phoneNumber
     * @param code
     * @return
     */
    public abstract ResponseResult verify(int identity, String phoneNumber, String Code);


}
