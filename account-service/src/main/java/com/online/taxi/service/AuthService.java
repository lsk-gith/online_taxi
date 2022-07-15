package com.online.taxi.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 16:12
 * @Description: com.online.taxi.accountservice.service
 * @version: 1.0
 */
public interface AuthService {
    /**
     * 生成验证码
     * @param phoneNum 手机号
     * @return string
     */
    public abstract String createToken(String phoneNum);
    /**
     * 检查验证码
     * @param token token
     * @return string
     */
    public abstract String checkToken(String token);

    /**
     * 删除token
     * @param subject subject
     */
    public abstract void deleteToken(String subject);

}
