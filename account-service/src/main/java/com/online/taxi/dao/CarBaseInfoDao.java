package com.online.taxi.dao;

import com.online.taxi.entity.CarBaseInfo;
import com.online.taxi.mapper.CarBaseInfoMapper;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lsk
 * @Date: 2022/7/20 - 07 - 20 - 22:10
 * @Description: com.online.taxi.dao
 * @version: 1.0
 */
@Repository
@RequiredArgsConstructor
public class CarBaseInfoDao {
    @NotNull
    private CarBaseInfoMapper carBaseInfoMapper;
    public int deleteByPrimaryKey(Integer id) {
        return carBaseInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(CarBaseInfo record) {
        return carBaseInfoMapper.insert(record);
    }

    public int insertSelective(CarBaseInfo record) {
        return carBaseInfoMapper.insertSelective(record);
    }

    public CarBaseInfo selectByPrimaryKey(Integer id) {
        return carBaseInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarBaseInfo record) {
        return carBaseInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CarBaseInfo record) {
        return carBaseInfoMapper.updateByPrimaryKey(record);
    }

}
