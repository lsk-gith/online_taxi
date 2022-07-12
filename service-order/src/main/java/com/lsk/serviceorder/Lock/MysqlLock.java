package com.lsk.serviceorder.Lock;

import com.lsk.common.entity.OrderLock;
import com.lsk.serviceorder.dao.OrderLockMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 22:48
 * @Description: com.lsk.serviceorder.Lock
 * @version: 1.0
 */
@Service
@Data
public class MysqlLock implements Lock {
    @Autowired
    private OrderLockMapper mapper;

    @Autowired
    private ThreadLocal<OrderLock> orderLockThreadLocal;

    @Override
    public void lock() {
        // 1、尝试加锁
        if(tryLock()) return;
        // 2.休眠
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 3.递归再次调用
        lock();
    }


    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 	非阻塞式加锁，成功，就成功，失败就失败。直接返回
     */
    @Override
    public boolean tryLock() {
        try {
            mapper.insertSelective(orderLockThreadLocal.get());
            System.out.println("加锁对象："+orderLockThreadLocal.get());
            return true;
        }catch (Exception e){

            return false;
        }

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        mapper.deleteByPrimaryKey(orderLockThreadLocal.get().getOrderId());
        System.out.println("解锁对象："+orderLockThreadLocal.get());
        orderLockThreadLocal.remove();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
