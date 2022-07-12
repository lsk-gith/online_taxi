package com.lsk.serviceorder.service.Impl;

import com.lsk.common.entity.Order;
import com.lsk.serviceorder.dao.OrderMapper;
import com.lsk.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:52
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean grab(int orderId, int driverId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        if(order.getStatus().intValue() == 0){
            order.setStatus(1);
            orderMapper.updateByPrimaryKeySelective(order);
            return true;
        }


        return false;
    }
}
