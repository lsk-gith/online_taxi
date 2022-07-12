package com.lsk.common.util;

import com.lsk.common.constant.IdentityConstant;
import com.lsk.common.constant.RedisKeyPrefixConstant;

/**
 * @Auther: lsk
 * @Date: 2022/7/11 - 07 - 11 - 22:59
 * @Description: com.lsk.common.util
 * @version: 1.0
 */
public class RedisKeyUtil {
    /**
     * 根据身份类型生成对应的缓存key
     * @param identity
     * @return
     */
    public static String generateKeyPreByIdentity(int identity){
        String keyPre = "";
        if(identity == IdentityConstant.PASSENGER){
            keyPre = RedisKeyPrefixConstant.PASSENGER_LOGIN_KEY_PRE;
        }else if(identity == IdentityConstant.DRIVER){
            keyPre = RedisKeyPrefixConstant.DRIVER_LOGIN_KEY_PRE;
        }
        return keyPre;
    }
}
