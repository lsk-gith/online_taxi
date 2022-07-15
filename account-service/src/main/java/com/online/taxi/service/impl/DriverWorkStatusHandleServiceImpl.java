package com.online.taxi.service.impl;

import com.online.taxi.constant.AccountStatusCode;
import com.online.taxi.dao.DriverInfoDao;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.request.DriverWorkStatusRequest;
import com.online.taxi.request.GetTokenRequest;
import com.online.taxi.service.DriverRegistHandleService;
import com.online.taxi.service.DriverWorkStatusHandleService;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Auther: lsk
 * @Date: 2022/7/18 - 07 - 18 - 22:46
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DriverWorkStatusHandleServiceImpl implements DriverWorkStatusHandleService {
    @NotNull
    private DriverInfoDao driverInfoDao;
    @NotNull
    private DriverInfoServiceImpl driverInfoService;

    /**
     * 修改司机工作状态
     * @param request 对象
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult changeWorkStatus(DriverWorkStatusRequest request) {
        Integer id = request.getId();
        DriverInfo driverInfo = driverInfoDao.selectByPrimaryKey(id);
        if(null == driverInfo){
            return ResponseResult.fail(AccountStatusCode.DRIVER_EMPTY.getCode(), AccountStatusCode.DRIVER_EMPTY.getValue());

        }
        //审核通过后，如果没有车辆，则提示
        Integer carId = driverInfo.getCarId();
        if(null == carId){
            return ResponseResult.fail(AccountStatusCode.DRIVER_NO_CAR.getCode(), AccountStatusCode.DRIVER_NO_CAR.getValue());
        }
        if(null != request.getCsWorkStatus()){
            Integer csWorkStatus = request.getCsWorkStatus();
            driverInfo.setCsWorkStatus(csWorkStatus);
        }
        if(null != request.getWorkStatus()){
            Integer workStatus = request.getWorkStatus();
            driverInfo.setWorkStatus(workStatus);
        }
        if(null != request.getIsFollowing()){
            Integer isFolling = request.getIsFollowing();
            driverInfo.setIsFollowing(isFolling);
        }

        // 改变司机状态
        int i = driverInfoService.updateDriverInfoByPhoneNum(driverInfo);


        if (0 == i) {
            return ResponseResult.fail("修改司机状态失败!");
        }else{
            return ResponseResult.success("");
        }
    }


}
