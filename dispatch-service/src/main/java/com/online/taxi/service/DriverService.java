package com.online.taxi.service;

import com.online.taxi.entity.DriverInfo;
import com.online.taxi.mapper.DriverInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 10:01
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
@Service
public class DriverService {
    @Autowired
    private DriverInfoMapper driverInfoMapper;

    public DriverInfo getDriverById(int id) {
        return driverInfoMapper.selectByPrimaryKey(id);
    }

    public DriverInfo getDriverByCarId(int carId) {
        return driverInfoMapper.selectByCarId(carId);
    }

    public void updateDriverInfo(DriverInfo driverInfo) {
        driverInfoMapper.updateByPrimaryKeySelective(driverInfo);
    }

    public int getWorkDriverCount(String city, int carType, Date startTime, Date endTime) {
        return driverInfoMapper.countWorkDriver(city, carType, startTime, endTime);
    }

    public Double getDriverEvaluateByDriverId(int driverId) {
        return driverInfoMapper.getDriverEvaluateByDriverId(driverId);
    }

    public int getDriverOrderCount(int driverId) {
        return driverInfoMapper.getDriverOrderCount(driverId);
    }



}
