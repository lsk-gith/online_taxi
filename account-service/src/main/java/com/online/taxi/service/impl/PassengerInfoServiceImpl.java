package com.online.taxi.service.impl;

import com.online.taxi.dao.PassengerAddressDao;
import com.online.taxi.dao.PassengerInfoDao;
import com.online.taxi.dao.PassengerWalletDao;
import com.online.taxi.request.GetTokenRequest;
import com.online.taxi.service.PassengerInfoService;
import com.online.taxi.cosntant.BusinessInterfaceStatus;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.*;
import com.sun.istack.internal.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 19:06
 * @Description: com.online.taxi.accountservice.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PassengerInfoServiceImpl implements PassengerInfoService {
    @NonNull
    private PassengerInfoDao passengerInfoDao;

    @NotNull
    private PassengerAddressDao passengerAddressDao;

    @NotNull
    private PassengerWalletDao passengerWalletDao;




    @Override
    public PassengerInfo queryPassengerInfoByPhoneNum(String phoneNum) {

        return passengerInfoDao.queryPassengerInfoByPhoneNum(phoneNum);
    }

    @Override
    public void insertPassengerInfo(PassengerInfo passengerInfo) {
        passengerInfoDao.insertSelective(passengerInfo);
    }

    @Override
    public void updatePassengerInfoLoginTime(Integer passengerId) {
        passengerInfoDao.updatePassengerInfoLoginTime(passengerId);
    }


    /**
     * 获取乘客信息
     * @param getTokenRequest 对象
     * @return HashMap<String, Object>
     */
    @Override
    public HashMap<String, Object> getPassengerInfoView(GetTokenRequest getTokenRequest) {
        HashMap<String, Object> view = new HashMap<>(16);
        PassengerInfo passengerInfo = passengerInfoDao.selectByPrimaryKey(getTokenRequest.getId());
        PassengerAddress passengerAddress = new PassengerAddress();
        passengerAddress.setPassengerInfoId(getTokenRequest.getId());
        List<PassengerAddress> passengerAddressList = new ArrayList<>();
        if(null != getTokenRequest.getType()){
            passengerAddress.setType(getTokenRequest.getType());
            passengerAddress = passengerAddressDao.selectByAddPassengerInfoId(passengerAddress);
        }else {
            passengerAddressList = passengerAddressDao.selectPassengerAddressList(getTokenRequest.getId());
        }

        if(null != passengerInfo){
            String decrypt;
            if(!StringUtils.isEmpty(passengerInfo.getPhone())){
                decrypt = EncriptUtil.decrypt(passengerInfo.getPhone());
                passengerInfo.setPhone(decrypt);
            }
            view.put("passengerInfo", passengerInfo);
        }
        if(null != passengerAddressList && 0 != passengerAddressList.size()){
            view.put("passengerAddressList", passengerAddressList);
        }
        if(null != passengerAddress && null != getTokenRequest.getType()){
            view.put("passengerAddress", passengerAddress);
        }

        return view;
    }

    /**
     * 修改乘客地址
     * @param passengerInfo 对象
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult updatePassengerInfo(PassengerInfo passengerInfo) {
        if(null != passengerInfo){
            if(!StringUtils.isEmpty(passengerInfo.getPhone())){
                String enPhoneNumber = EncriptUtil.encryptionPhoneNumber(passengerInfo.getPhone());
                passengerInfo.setPhone(enPhoneNumber);
            }
        }
        int updateOrInsert;
        if(null != passengerInfo && null != passengerInfo.getId()){
            updateOrInsert = passengerInfoDao.updateByPrimaryKeySelective(passengerInfo);
        }else {
            if(null != passengerInfo){
                passengerInfo.setCreateTime(new Date());
            }
            updateOrInsert = passengerInfoDao.insertSelective(passengerInfo);
        }
        if(0 == updateOrInsert){
            return ResponseResult.fail(BusinessInterfaceStatus.FAIL.getCode(), "修改或添加乘客信息失败!");
        }else
        return ResponseResult.success("");
    }

    @Override
    public int initPassengerWallet(Integer passengerId) {
        return 0;
    }

    @Override
    public PassengerInfo queryPassengerInfoById(Integer passengerId) {
        return passengerInfoDao.queryPassengerInfoById(passengerId);
    }

    @Override
    public int insertPassengerRegisterSource(PassengerRegisterSource passengerRegisterSource) {
        return passengerInfoDao.insertPassengerRegisterSource(passengerRegisterSource);
    }

    @Override
    public int updatePassengerInfoById(PassengerInfo passengerInfo) {
        return passengerInfoDao.updateByPrimaryKeySelective(passengerInfo);
    }
}
