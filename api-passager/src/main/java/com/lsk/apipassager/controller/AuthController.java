package com.lsk.apipassager.controller;

import com.lsk.apipassager.request.UserAuthRequest;
import com.lsk.apipassager.service.AuthService;
import com.lsk.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:06
 * @Description: com.lsk.apipassager.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    public ResponseResult login(@RequestBody @Validated UserAuthRequest userAuthRequest){
        String passengerPhone = userAuthRequest.getPassengerPhone();
        String code = userAuthRequest.getCode();
        return authService.auth(passengerPhone,code);
    }


}
