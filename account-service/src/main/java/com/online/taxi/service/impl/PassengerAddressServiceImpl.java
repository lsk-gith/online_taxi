package com.online.taxi.service.impl;

import com.online.taxi.dao.PassengerAddressDao;
import com.online.taxi.service.PassengerAddressService;
import com.online.taxi.cosntant.BusinessInterfaceStatus;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.PassengerAddress;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 10:28
 * @Description: com.online.taxi.accountservice.service.impl
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class PassengerAddressServiceImpl implements PassengerAddressService {
    @NotNull
    private PassengerAddressDao passengerAddressDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return passengerAddressDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PassengerAddress record) {
        return passengerAddressDao.insert(record);
    }

    @Override
    public int insertSelective(PassengerAddress record) {
        return passengerAddressDao.insertSelective(record);
    }

    @Override
    public PassengerAddress selectByPrimaryKey(Integer id) {
        return passengerAddressDao.selectByPrimaryKey(id);
    }

    @Override
    public List<PassengerAddress> selectPassengerAddressList(Integer PassengerInfoId) {
        return passengerAddressDao.selectPassengerAddressList(PassengerInfoId);
    }

    @Override
    public PassengerAddress selectByAddPassengerInfoId(PassengerAddress passengerInfoId) {
        return passengerAddressDao.selectByAddPassengerInfoId(passengerInfoId);
    }

    @Override
    public int updateByPrimaryKeySelective(PassengerAddress record) {
        return passengerAddressDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public ResponseResult updatePassengerAddress(PassengerAddress record) {
        int updateOrInsert = 0;
        if(null != record.getPassengerInfoId()){
            PassengerAddress passengerAddress = passengerAddressDao.selectByAddPassengerInfoId(record);
            if(null == passengerAddress){
                passengerAddress.setCreateTime(new Date());
                passengerAddressDao.insertSelective(passengerAddress);
            }else {
                updateOrInsert = passengerAddressDao.updatePassengerAddress(passengerAddress);
            }
        }else {
            record.setCreateTime(new Date());
            updateOrInsert = passengerAddressDao.insertSelective(record);
        }
        if(0 == updateOrInsert){
            return ResponseResult.fail(BusinessInterfaceStatus.FAIL.getCode(), "修改或添加乘客地址信息失败!");

        }else {
            return ResponseResult.success("修改或添加乘客地址信息成功!");
        }

    }

    @Override
    public int updateByPrimaryKey(PassengerAddress record) {
        return passengerAddressDao.updateByPrimaryKey(record);
    }
}
