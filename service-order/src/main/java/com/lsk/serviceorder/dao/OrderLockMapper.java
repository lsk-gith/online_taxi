package com.lsk.serviceorder.dao;

import com.lsk.common.entity.OrderLock;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 22:51
 * @Description: com.lsk.serviceorder.dao
 * @version: 1.0
 */
public interface OrderLockMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insertSelective(OrderLock record);
}
