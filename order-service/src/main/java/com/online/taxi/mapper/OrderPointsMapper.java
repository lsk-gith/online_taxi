package com.online.taxi.mapper;

import com.online.taxi.entity.OrderPoints;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderPointsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderPoints record);

    int insertSelective(OrderPoints record);

    OrderPoints selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderPoints record);

    int updateByPrimaryKeyWithBLOBs(OrderPoints record);

    int updateByPrimaryKey(OrderPoints record);
}