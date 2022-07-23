package com.online.taxi.data;

import com.online.taxi.entity.CarInfo;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.map.Vehicle;
import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 22:38
 * @Description: com.online.taxi.data
 * @version: 1.0
 */
@Data
public class DriverData {
    private Vehicle amapVehicle;
    private DriverInfo driverInfo;
    private double homeDistance;
    private CarInfo carInfo;
    private int isFollowing;
    private int timeSort;
}
