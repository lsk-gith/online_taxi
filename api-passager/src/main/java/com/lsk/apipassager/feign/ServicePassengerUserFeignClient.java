package com.lsk.apipassager.feign;

import com.lsk.apipassager.feign.response.PassengerUserInfo;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.passengeruser.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:13
 * @Description: com.lsk.apipassager.feign
 * @version: 1.0
 */
@FeignClient(name = "service-passenger-user")
public interface ServicePassengerUserFeignClient {
    @RequestMapping(value = "/auth/login",method = RequestMethod.POST)
    public ResponseResult<PassengerUserInfo> login(@RequestBody LoginRequest loginRequest);
}
