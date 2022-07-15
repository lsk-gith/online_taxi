package com.online.taxi.service.impl;

import com.online.taxi.service.AuthService;
import com.online.taxi.service.TokenRedisService;
import com.online.taxi.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 16:11
 * @Description: com.online.taxi.accountservice
 * @version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Autowired
    private final TokenRedisService tokenRedisService;

    /**
     * token有效期 60天
     */
    private static final Integer EXP_HOURS = 24 * 60;

    /**
     * 生成token
     * @param subject 身份_电话号码_ID
     * @return string
     */
    @Override
    public String createToken(String subject) {
        String jwtStr = JwtUtil.createJWT(subject, new Date());
        tokenRedisService.put(subject, jwtStr, EXP_HOURS);
        return jwtStr;
    }

    /**
     * 检验token
     * @param token token
     * @return string
     */
    @Override
    public String checkToken(String token) {
        try {
            Claims claims = JwtUtil.parseJWT(token);
            if(null != claims){
                String tokenT = tokenRedisService.get(claims.getSubject());
                log.info("缓存中的认证key:" + claims.getSubject() + ",value:" + tokenT);
                if (StringUtils.isNotEmpty(tokenT) && token.equals(tokenT)) {
                    log.info("验证Token是否失效 - Token仍有效 - 延长token有效期phone: " + claims.getSubject() + " token:" + tokenT);
                    tokenRedisService.expire(claims.getSubject(), EXP_HOURS);
                    return claims.getSubject();
                }else{
                    log.info("验证Token是否失效 - Token已失效 - token已过期 - token:" + token);
                    return "1";
                }
            }else{
                log.info("验证Token是否失效 - Token已失效 - token已过期 - token:" + token);
                return "1";
            }
        }catch (Exception e){
            log.error("验证Token是否失效 - 服务器异常", e);
            return "1";
        }
    }

    /**
     * 删除token
     * @param subject subject
     */
    @Override
    public void deleteToken(String subject) {
        tokenRedisService.delete(subject);
    }
}
