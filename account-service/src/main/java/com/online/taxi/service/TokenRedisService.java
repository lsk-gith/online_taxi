package com.online.taxi.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 16:26
 * @Description: com.online.taxi.accountservice.service
 * @version: 1.0
 */
public interface TokenRedisService {

    public abstract void put(String phoneNum, String token, Integer expHours);

    public abstract String get(String phoneNum);

    public abstract boolean expire(String phoneNum, Integer expHours);

    public abstract void delete(String phoneNum);


}
