package com.lsk.common.util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:29
 * @Description: com.lsk.common.util
 * @version: 1.0
 */
public class JwtUtil {
    /**
     * 密钥，仅服务端存储
     */
    private static String secret = "ko346134h_we]rg3in_yip1!";
    /**
     *
     * @param subject
     * @param issueDate 签发时间
     * @return
     */
    public static String createToken(String subject, Date issueDate){
        String compact = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 60 * 60 * 24 * 30))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return compact;
    }



    /**
     * 解密 jwt
     * @param token
     * @return
     * @throws Exception
     */
    public static String parseToken(String token){
        try {
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            if(body != null){
                return body.getSubject();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("jwt 过期了");
        }
        return null;
    }

    public static void main(String[] args) {
        String subject = "1";
        String token  = createToken(subject, new Date());
        System.out.println(token);
        try {
//            Thread.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(parseToken(token));
    }


}
