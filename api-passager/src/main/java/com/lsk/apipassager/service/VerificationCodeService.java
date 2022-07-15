package com.lsk.apipassager.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 21:15
 * @Description: com.lsk.apipassager.service
 * @version: 1.0
 */
public interface VerificationCodeService {
    /**
     * 	获取验证码
     * @param phonenumber
     * @return
     */
    public String getCode(String phonenumber);
    /**
     * 	校验验证码
     * @param phonenumber
     * @param code
     * @return
     */
    public String checkCode(String phonenumber,String code);
}
