package com.online.taxi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 17:13
 * @Description: com.online.taxi.accountservice.util
 * @version: 1.0
 */
public class JwtUtil {

    private static String secret = "ko346134h_we]rg3in_yip1!";
    /**
     * 生成TOKEN
     * @param subject subject
     * @param issueDate 时间
     * @return string
     */
    public static String createJWT(String subject, Date issueDate){
        String compactJws = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
        return compactJws;
    }

    /**
     * 解密 jwt
     * @param jwt 需要解密的字符串
     * @return Claims 对象
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
        return claims;
    }

}
