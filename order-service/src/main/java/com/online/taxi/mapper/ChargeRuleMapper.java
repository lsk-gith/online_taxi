package com.online.taxi.mapper;

import com.online.taxi.entity.ChargeRule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChargeRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChargeRule record);

    int insertSelective(ChargeRule record);

    ChargeRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeRule record);

    int updateByPrimaryKey(ChargeRule record);

    ChargeRule getChargeRule(@Param("cityCode") String cityCode, @Param("serviceTypeId") int serviceTypeId, @Param("carLevel") int carLevel);

    List<ChargeRule> selectByPrimaryKey(ChargeRule chargeRule);
}