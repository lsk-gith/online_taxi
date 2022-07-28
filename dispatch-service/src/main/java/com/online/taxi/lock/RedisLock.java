package com.online.taxi.lock;

import com.online.taxi.db.RedisDb;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: lsk
 * @Date: 2022/7/24 - 07 - 24 - 11:19
 * @Description: com.online.taxi
 * @version: 1.0
 */
public class RedisLock {
    private RedisDb redisDb;
    public void lock(String key){
        int k =0;
        for (;;){
            boolean r = redisDb.setnx(key, "", 20);
            if(r)
                return;
            if(k++ >= 300){
                throw new RuntimeException("lock error key = " + key);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10 + new Random().nextInt(20));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public void unlock(String key) {
        redisDb.delete(key);
    }

    private static class LazyHodler {
        private static RedisLock ins = new RedisLock();
    }

    public static RedisLock ins() {
        return RedisLock.LazyHodler.ins;
    }
}
