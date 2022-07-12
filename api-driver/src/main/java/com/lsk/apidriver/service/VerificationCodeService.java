package com.lsk.apidriver.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 15:45
 * @Description: com.lsk.apidriver.service
 * @version: 1.0
 */
public interface VerificationCodeService {
    /*
     * 	获取验证码
     * @param phonenumber
     * @return
     */
    String getCode(String phoneNumber);
    /*
     * 	校验验证码
     * @param phonenumber
     * @param code
     * @return
     */
    String checkCode(String phoneNumber,String Code);
}
