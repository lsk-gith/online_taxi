package com.online.taxi.mapper;

import com.online.taxi.entity.CarDispatchCapacitySet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarDispatchCapacitySetMapper {

    CarDispatchCapacitySet getCarDispatchCapacitySet(@Param("cityCode") String cityCode, @Param("timeType") int timeType);

    List<CarDispatchCapacitySet> getCarDispatchCapacitySetList(@Param("cityCode") String cityCode);

}
