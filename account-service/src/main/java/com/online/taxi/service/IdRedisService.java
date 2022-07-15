package com.online.taxi.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 14:56
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface IdRedisService {
    public abstract String pull(Integer idType, Integer id);
    public abstract void push(Integer idType, Integer id, String phone, Integer expHours);
}
