package com.online.taxi.dao;

import com.online.taxi.entity.DriverBaseInfo;
import com.online.taxi.mapper.DriverBaseInfoMapper;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 17:20
 * @Description: com.online.taxi.dao
 * @version: 1.0
 */
@Repository
@RequiredArgsConstructor
public class DriverBaseInfoDao {
    @NotNull
    private DriverBaseInfoMapper driverBaseInfoMapper;
    public int deleteByPrimaryKey(Integer id) {
        return driverBaseInfoMapper.deleteByPrimaryKey(id);
    }


    public int insert(DriverBaseInfo record) {
        return driverBaseInfoMapper.insert(record);
    }


    public int insertSelective(DriverBaseInfo record) {
        return driverBaseInfoMapper.insertSelective(record);
    }


    public DriverBaseInfo selectByPrimaryKey(Integer id) {
        return driverBaseInfoMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(DriverBaseInfo record) {
        return driverBaseInfoMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(DriverBaseInfo record) {
        return driverBaseInfoMapper.updateByPrimaryKey(record);
    }
}
