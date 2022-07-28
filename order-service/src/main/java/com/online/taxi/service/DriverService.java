package com.online.taxi.service;

import com.online.taxi.entity.DriverInfo;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/25 - 07 - 25 - 22:14
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface DriverService {
    /**
     *  查询司机
     */

    public abstract List<DriverInfo> selectDriverList();

}
