package com.lsk.serviceorder.service.Impl;

import com.lsk.serviceorder.service.RenewGrabLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 22:31
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
public class RenewGrabLockServiceImpl implements RenewGrabLockService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    @Async
    public void renewLock(String key, String value, int time) {
        String v = redisTemplate.opsForValue().get(key);
        if(v.equals(value)){
            int sleepTime = time / 3;
            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.expire(key,time, TimeUnit.SECONDS);
            renewLock(key,value,time);
        }
    }
}
