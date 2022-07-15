package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.PassengerAddress;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 10:27
 * @Description: com.online.taxi.accountservice.service
 * @version: 1.0
 */
public interface PassengerAddressService {
    int deleteByPrimaryKey(Integer id);

    int insert(PassengerAddress record);

    int insertSelective(PassengerAddress record);

    PassengerAddress selectByPrimaryKey(Integer id);

    List<PassengerAddress> selectPassengerAddressList(Integer PassengerInfoId);

    PassengerAddress selectByAddPassengerInfoId(PassengerAddress passengerInfoId);

    int updateByPrimaryKeySelective(PassengerAddress record);

    ResponseResult updatePassengerAddress(PassengerAddress record);

    int updateByPrimaryKey(PassengerAddress record);
}
