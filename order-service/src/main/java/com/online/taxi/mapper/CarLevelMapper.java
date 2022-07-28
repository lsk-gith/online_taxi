package com.online.taxi.mapper;

import com.online.taxi.entity.CarLevel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CarLevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarLevel record);

    int insertSelective(CarLevel record);

    CarLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarLevel record);

    int updateByPrimaryKey(CarLevel record);
}