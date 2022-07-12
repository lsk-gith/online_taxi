package com.lsk.serviceorder.service;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:50
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
public interface RenewGrabLockService {
    /**
     * 续约
     * @param key
     * @param value
     * @param time
     */
    public abstract void renewLock(String key, String value, int time);
}
