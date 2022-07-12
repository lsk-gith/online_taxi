package com.lsk.serviceorder.service.Impl;

import com.lsk.common.dto.ResponseResult;
import com.lsk.common.entity.OrderLock;
import com.lsk.serviceorder.Lock.MysqlLock;
import com.lsk.serviceorder.service.GrabService;
import com.lsk.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:45
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
public class GrabMysqlLockServiceImpl implements GrabService {
    @Autowired
    private MysqlLock lock;

    @Autowired
    OrderService orderService;

    ThreadLocal<OrderLock> orderLock = new ThreadLocal<>();

    @Override
    public ResponseResult grabOrder(int orderId, int driverId) {
        OrderLock oL1 = new OrderLock();
        oL1.setOrderId(orderId);
        oL1.setDriverId(driverId);
        orderLock.set(oL1);
        lock.setOrderLockThreadLocal(orderLock);
        lock.lock();
        //        System.out.println("司机"+driverId+"加锁成功");

        try {
            System.out.println("司机:"+driverId+" 执行抢单逻辑");

            boolean b = orderService.grab(orderId, driverId);
            if(b) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }

        } finally {

            lock.unlock();
        }


        return null;
    }
}
