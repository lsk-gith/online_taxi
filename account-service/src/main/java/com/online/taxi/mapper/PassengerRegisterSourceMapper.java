package com.online.taxi.mapper;

import com.online.taxi.entity.PassengerRegisterSource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * PassengerRegisterSourceMapper继承基类
 */
@Mapper
@Repository
public interface PassengerRegisterSourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PassengerRegisterSource record);

    int insertSelective(PassengerRegisterSource record);

    PassengerRegisterSource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PassengerRegisterSource record);

    int updateByPrimaryKey(PassengerRegisterSource record);
}