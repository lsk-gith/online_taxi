package com.online.taxi.dao;

import com.online.taxi.mapper.PassengerAddressMapper;
import com.online.taxi.entity.PassengerAddress;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 20:16
 * @Description: com.online.taxi.accountservice.dao
 * @version: 1.0
 */
@Repository
@RequiredArgsConstructor
public class PassengerAddressDao {
    @NotNull
    private PassengerAddressMapper passengerAddressDao;
    public int deleteByPrimaryKey(Integer id) {
        return passengerAddressDao.deleteByPrimaryKey(id);
    }

    public int insert(PassengerAddress record) {
        return passengerAddressDao.insert(record);
    }

    public int insertSelective(PassengerAddress record) {
        return passengerAddressDao.insertSelective(record);
    }

    public PassengerAddress selectByPrimaryKey(Integer id) {
        return passengerAddressDao.selectByPrimaryKey(id);
    }

    public PassengerAddress selectByPassengerInfoId(Integer passengerInfoId) {
        return passengerAddressDao.selectByPassengerInfoId(passengerInfoId);
    }

    public List<PassengerAddress> selectPassengerAddressList(Integer passengerInfoId) {
        return passengerAddressDao.selectPassengerAddressList(passengerInfoId);
    }

    public PassengerAddress selectByAddPassengerInfoId(PassengerAddress passengerInfoId ) {
        return passengerAddressDao.selectByAddPassengerInfoId(passengerInfoId);
    }

    public int updateByPrimaryKeySelective(PassengerAddress record) {
        return passengerAddressDao.updateByPrimaryKeySelective(record);
    }

    public int updatePassengerAddress(PassengerAddress record) {
        return passengerAddressDao.updatePassengerAddress(record);
    }

    public int updateByPrimaryKey(PassengerAddress record) {
        return passengerAddressDao.updateByPrimaryKey(record);
    }



}
