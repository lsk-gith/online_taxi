package com.lsk.serviceorder.controller;

import com.lsk.common.dto.ResponseResult;
import com.lsk.serviceorder.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:43
 * @Description: com.lsk.serviceorder.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/grab")
public class GrabOrderController {
    @Autowired
    // 无锁
//    @Qualifier("grabNoLockService")
    // jvm锁
//    @Qualifier("grabJvmLockService")
    // mysql锁
//    @Qualifier("grabMysqlLockService")
    //单个redisson
    @Qualifier("grabRedisRedissonService")
    // 红锁
//    @Qualifier("grabRedisRedissonRedLockLockService")
    private GrabService grabService;


    @GetMapping("/do/{orderId}")
    public String grab(@PathVariable("orderId") int orderId, int driverId){
        ResponseResult responseResult = grabService.grabOrder(orderId, driverId);
        return null;
    }


}
