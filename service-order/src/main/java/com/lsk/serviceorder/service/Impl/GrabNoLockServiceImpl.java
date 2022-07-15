package com.lsk.serviceorder.service.Impl;

import com.lsk.common.dto.ResponseResult;
import com.lsk.serviceorder.service.GrabService;
import com.lsk.serviceorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 21:11
 * @Description: com.lsk.serviceorder.service.Impl
 * @version: 1.0
 */
@Service("grabNoLockService")
public class GrabNoLockServiceImpl implements GrabService {
    @Autowired
    OrderService orderService;
    @Override
    public ResponseResult grabOrder(int orderId, int driverId) {
        try {
            System.out.println("司机:"+driverId+" 执行抢单逻辑");
            boolean grab = orderService.grab(orderId, driverId);
            if(grab) {
                System.out.println("司机:"+driverId+" 抢单成功");
            }else {
                System.out.println("司机:"+driverId+" 抢单失败");
            }


        }finally {

        }


        return null;
    }
}
