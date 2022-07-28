package com.online.taxi.mapper;

import com.online.taxi.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DriverInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DriverInfo record);

    int insertSelective(DriverInfo record);

    DriverInfo selectByPrimaryKey(Integer id);

    List<DriverInfo> selectDriverInfoList();

    int updateByPrimaryKeySelective(DriverInfo record);

    int updateByPrimaryKey(DriverInfo record);

    int updateCarIdById(DriverInfo record);

    DriverInfo queryDriverInfoByPhoneNum(String phoneNum);

    DriverInfo queryDriverInfoByCarId(Integer carId);

    int updateDriverInfoByPhoneNum(DriverInfo driverInfo);
}