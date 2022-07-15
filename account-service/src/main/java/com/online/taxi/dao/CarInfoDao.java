package com.online.taxi.dao;

import com.online.taxi.entity.CarInfo;
import com.online.taxi.mapper.CarInfoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Auther: lsk
 * @Date: 2022/7/19 - 07 - 19 - 22:55
 * @Description: com.online.taxi.dao
 * @version: 1.0
 */
@Repository
@RequiredArgsConstructor
public class CarInfoDao {
    @NonNull
    private CarInfoMapper carInfoMapper;

    public int deleteByPrimaryKey(Integer id) {
        return carInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(CarInfo record) {
        return carInfoMapper.insert(record);
    }

    public int insertSelective(CarInfo record) {
        return carInfoMapper.insertSelective(record);
    }

    public CarInfo selectByPrimaryKey(Integer id) {
        return carInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(CarInfo record) {
        return carInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(CarInfo record) {
        return carInfoMapper.updateByPrimaryKey(record);
    }

    public int countCarInfo(Map<String, Object> param) {
        return carInfoMapper.countCarInfo(param);
    }

}
