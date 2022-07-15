package com.online.taxi.service.impl;

import com.online.taxi.dao.CarInfoDao;
import com.online.taxi.entity.CarInfo;
import com.online.taxi.service.CarInfoService;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Auther: lsk
 * @Date: 2022/7/19 - 07 - 19 - 22:54
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
@RequiredArgsConstructor
public class CarInfoServiceImpl implements CarInfoService {
    @NotNull
    private CarInfoDao carInfoDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return carInfoDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CarInfo record) {
        return carInfoDao.insert(record);
    }

    @Override
    public int insertSelective(CarInfo record) {
        return carInfoDao.insertSelective(record);
    }

    @Override
    public CarInfo selectByPrimaryKey(Integer id) {
        return carInfoDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CarInfo record) {
        return carInfoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CarInfo record) {
        return carInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public int countCarInfo(Map<String, Object> param) {
        return carInfoDao.countCarInfo(param);
    }

}
