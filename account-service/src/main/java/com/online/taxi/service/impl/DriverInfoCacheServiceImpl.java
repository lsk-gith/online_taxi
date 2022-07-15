package com.online.taxi.service.impl;

import com.online.taxi.service.DriverInfoCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 17:26
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DriverInfoCacheServiceImpl implements DriverInfoCacheService {
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> vOps;

    private static final String DRIVER_KEY = "driver_info_";

    /**
     * 获取信息
     * @param phoneNum 手机号
     * @return string
     */
    @Override
    public String get(String phoneNum) {
        String key = DRIVER_KEY + phoneNum;
        return vOps.get(key);
    }
    /**
     * 司机缓存中状态,放到缓存中
     * @param phoneNum 手机号
     * @param value 司机对象信息
     */
    @Override
    public void put(String phoneNum, String value) {
        String key = DRIVER_KEY + phoneNum;
        vOps.set(key, value);
        log.info("hashKey:" + key + " 缓存在Redis中的hashValue为:" + value);
    }
}
