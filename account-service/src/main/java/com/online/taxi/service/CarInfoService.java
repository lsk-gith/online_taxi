package com.online.taxi.service;

import com.online.taxi.entity.CarInfo;

import java.util.Map;

/**
 * @Auther: lsk
 * @Date: 2022/7/19 - 07 - 19 - 22:54
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface CarInfoService {
    int deleteByPrimaryKey(Integer id);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    CarInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);

    int countCarInfo(Map<String, Object> param);
}
