package com.lsk.serviceorder.service.Impl;

import com.lsk.common.dto.ResponseResult;
import com.lsk.serviceorder.service.GrabService;
import com.lsk.serviceorder.service.OrderService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 21:42
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
@Service("grabRedisRedissonService")
public class GrabRedisRedissonServiceImpl implements GrabService {
    @Autowired
    RedissonClient redissonClient;

    @Autowired
    OrderService orderService;


    @Override
    public ResponseResult grabOrder(int orderId, int driverId) {
        String lock = "order_"+(orderId+"");
        RLock rLock = redissonClient.getLock(lock);
        try {
            rLock.lock();
            System.out.println("司机:"+driverId+" 执行抢单逻辑");
            boolean b = orderService.grab(orderId, driverId);
            if(b) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }

        }finally {
            rLock.unlock();
        }

        return null;
    }
}
