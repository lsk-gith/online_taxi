package com.online.taxi.mapper;

import com.online.taxi.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int countByBetweenTime(@Param("driverId") int driverId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int countOrderByParam(@Param("driverId") int driverId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int countDriverByParam(@Param("driverId") int driverId, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

}