package com.lsk.apilistenorder.listen.service.Impl;

import com.lsk.apilistenorder.listen.response.PreGrabResponse;
import com.lsk.apilistenorder.listen.service.ListenService;
import com.lsk.common.constant.RedisKeyConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 22:11
 * @Description: com.lsk.apilistenorder.listen.service.Impl
 * @version: 1.0
 */
@Service
public class ListenServiceImpl implements ListenService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    @Override
    public PreGrabResponse listen(int driverId) {
        String key = RedisKeyConstant.DRIVER_LISTEN_ORDER_PRE + driverId;
        String orderId = redisTemplate.opsForValue().get(key);
        redisTemplate.delete(orderId);
        PreGrabResponse preGrabResponse = new PreGrabResponse();
        try {
            if (StringUtils.isNotBlank(orderId)){
                preGrabResponse.setEndAddress("终点" + new Random().nextInt());
                preGrabResponse.setStartAddress("起点" + new Random().nextInt());
                preGrabResponse.setOrderId(Integer.parseInt(orderId));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return preGrabResponse;
        }
    }
}
