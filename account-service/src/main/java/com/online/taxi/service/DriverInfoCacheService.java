package com.online.taxi.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 17:25
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface DriverInfoCacheService {
    /**
     * 查询司机信息
     * @param phoneNum 手机号
     * @return string
     */
    public abstract String get(String phoneNum);

    /**
     * 保存司机信息
     * @param phoneNum 手机号
     * @param driverInfo 对象
     */
    public abstract void put(String phoneNum, String driverInfo);
}
