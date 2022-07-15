package com.lsk.apilistenorder.controller;

import com.lsk.apilistenorder.listen.service.ListenService;
import com.lsk.common.constant.RedisKeyConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 22:34
 * @Description: com.lsk.apilistenorder.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/order")
public class SendOrderController {
    @Autowired
    private ListenService listenService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @GetMapping("/send")
    public String sendOrder(String driverId){
        String key = RedisKeyConstant.DRIVER_LISTEN_ORDER_PRE + driverId;
//        感觉这里逻辑有点问题，不应该是orderId才是派单吗？？？，咋是driverId??
        redisTemplate.opsForValue().set(key, driverId);
        return "给"+driverId+"司机 发订单成功";
    }


}
