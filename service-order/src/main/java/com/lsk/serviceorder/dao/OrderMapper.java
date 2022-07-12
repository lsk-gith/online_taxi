package com.lsk.serviceorder.dao;

import com.lsk.common.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:53
 * @Description: com.lsk.serviceorder.dao
 * @version: 1.0
 */
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}
