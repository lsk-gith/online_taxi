package com.online.taxi.mapper;

import com.online.taxi.entity.OrderRuleMirror;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lsk
 * @Date: 2022/7/26 - 07 - 26 - 21:12
 * @Description: com.online.taxi.mapper
 * @version: 1.0
 */
@Mapper
@Repository
public interface OrderRuleMirrorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderRuleMirror record);

    int insertSelective(OrderRuleMirror record);

    OrderRuleMirror selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderRuleMirror record);

    int updateByPrimaryKeyWithBLOBs(OrderRuleMirror record);

    int updateByPrimaryKey(OrderRuleMirror record);
}
