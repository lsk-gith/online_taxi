package com.online.taxi.mapper;

import com.online.taxi.entity.CarDispatchDistributeRadiusSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CarDispatchDistributeRadiusSetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CarDispatchDistributeRadiusSet record);

    int insertSelective(CarDispatchDistributeRadiusSet record);

    CarDispatchDistributeRadiusSet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CarDispatchDistributeRadiusSet record);

    int updateByPrimaryKey(CarDispatchDistributeRadiusSet record);

    CarDispatchDistributeRadiusSet getCarDispatchDistributeRadiusSet(@Param("cityCode") String cityCode, @Param("serviceTypeId") int serviceTypeId);
}
