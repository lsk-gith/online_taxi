package com.online.taxi.mapper;

import com.online.taxi.entity.DriverBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DriverBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DriverBaseInfo record);

    int insertSelective(DriverBaseInfo record);

    DriverBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DriverBaseInfo record);

    int updateByPrimaryKey(DriverBaseInfo record);
}