package com.online.taxi.service;

import com.online.taxi.dto.DriverBaseInfoView;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.request.UpdateDriverAddressRequest;

import java.util.HashMap;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 16:57
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface DriverInfoService {
    DriverInfo queryDriverInfoByPhoneNum(String phoneNum);

    int updateDriverInfoByPhoneNum(DriverInfo driverInfo);

    ResponseResult changeDriverBaseInfo(DriverBaseInfoView view, int type);

    HashMap<String, Object> getDriverBaseInfoView(int driverId);

    ResponseResult updateDriverAddressRequest(UpdateDriverAddressRequest request);

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    int updateCarIdById(DriverInfo record);
}
