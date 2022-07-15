package com.online.taxi.service;

import com.online.taxi.request.GetTokenRequest;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.PassengerInfo;
import com.online.taxi.entity.PassengerRegisterSource;

import java.util.HashMap;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 18:29
 * @Description: com.online.taxi.accountservice.service
 * @version: 1.0
 */
public interface PassengerInfoService {
    PassengerInfo queryPassengerInfoByPhoneNum(String phoneNum);

    void insertPassengerInfo(PassengerInfo passengerInfo) ;

    void updatePassengerInfoLoginTime(Integer passengerId);

    HashMap<String, Object> getPassengerInfoView(GetTokenRequest getTokenRequest);

    ResponseResult updatePassengerInfo(PassengerInfo passengerInfo);

    int initPassengerWallet(Integer passengerId);

    PassengerInfo queryPassengerInfoById(Integer passengerId);

    int insertPassengerRegisterSource(PassengerRegisterSource passengerRegisterSource);

    int updatePassengerInfoById(PassengerInfo passengerInfo);
}
