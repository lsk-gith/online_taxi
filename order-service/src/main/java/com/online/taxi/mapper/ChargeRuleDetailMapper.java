package com.online.taxi.mapper;

import com.online.taxi.entity.ChargeRuleDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChargeRuleDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChargeRuleDetail record);

    int insertSelective(ChargeRuleDetail record);

    List<ChargeRuleDetail> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChargeRuleDetail record);

    int updateByPrimaryKey(ChargeRuleDetail record);
}