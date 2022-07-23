package com.online.taxi.mapper;

import com.online.taxi.entity.CarBaseInfo;
import org.springframework.stereotype.Service;

/**
 * @date 2018/08/10
 */
@Service
public interface CarBaseInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CarBaseInfo record);

    int insertSelective(CarBaseInfo record);

    CarBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarBaseInfo record);

    int updateByPrimaryKey(CarBaseInfo record);
}
