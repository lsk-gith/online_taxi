package com.lsk.serviceorder.service.Impl;

import com.lsk.common.constant.RedisKeyConstant;
import com.lsk.common.dto.ResponseResult;
import com.lsk.serviceorder.service.GrabService;
import com.lsk.serviceorder.service.OrderService;
import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 21:26
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
@Service("grabRedisRedissonRedLockLockService")
public class GrabRedisRedissonRedLockLockServiceImpl implements GrabService {
    @Autowired
    private RedissonClient redissonClient1;
    @Autowired
    private RedissonClient redissonRed1;
    @Autowired
    private RedissonClient redissonRed2;
    @Autowired
    private RedissonClient redissonRed3;
    @Autowired
    OrderService orderService;


    @Override
    public ResponseResult grabOrder(int orderId, int driverId) {
        String lockKey = (RedisKeyConstant.GRAB_LOCK_ORDER_KEY_PRE + orderId).intern();
        //redisson锁 哨兵
//        RLock rLock = redisson.getLock(lockKey);
//        rLock.lock();

        //redisson锁 单节点
        RLock lock = redissonClient1.getLock(lockKey);

        //红锁
        RLock rLock1 = redissonRed1.getLock(lockKey);
        RLock rLock2 = redissonRed2.getLock(lockKey);
        RLock rLock3 = redissonRed2.getLock(lockKey);
        RedissonRedLock rLock = new RedissonRedLock(rLock1,rLock2,rLock3);

//        rLock.lock();
        lock.lock();
        try {
            // 此代码默认 设置key 超时时间30秒，过10秒，再延时
            System.out.println("司机:"+driverId+" 执行抢单逻辑");
            boolean b = orderService.grab(orderId, driverId);
            if(b){
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }
        }finally {
//            rLock.unlock();
            lock.unlock();

        }


        return null;
    }
}
