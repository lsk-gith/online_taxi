package com.lsk.apipassager.service.Impl;

import com.lsk.apipassager.feign.ServicePassengerUserFeignClient;
import com.lsk.apipassager.feign.ServiceVerificationCodeFeignClient;
import com.lsk.apipassager.feign.request.CodeVerifyRequest;
import com.lsk.apipassager.feign.response.PassengerUserInfo;
import com.lsk.apipassager.response.UserAuthResponse;
import com.lsk.apipassager.service.AuthService;
import com.lsk.common.constant.IdentityConstant;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.passengeruser.LoginRequest;
import com.lsk.common.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:08
 * @Description: com.lsk.apipassager.service.Impl
 * @version: 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ServiceVerificationCodeFeignClient serviceVerificationCodeFeignClient;

    @Autowired
    private ServicePassengerUserFeignClient servicePassengerUserFeignClient;


    @Override
    public ResponseResult auth(String passengerPhone, String code) {
        CodeVerifyRequest codeVerifyRequest = new CodeVerifyRequest();
        codeVerifyRequest.setPhoneNumber(passengerPhone);
        codeVerifyRequest.setCode(code);
        codeVerifyRequest.setIdentity(IdentityConstant.PASSENGER);
        ResponseResult verify = serviceVerificationCodeFeignClient.verify(codeVerifyRequest);
        if(verify.getCode() != 1){
            return ResponseResult.fail(verify.getCode(),verify.getMessage());
        }

        //乘客用户登录
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassengerPhone(passengerPhone);
        ResponseResult<PassengerUserInfo> login = servicePassengerUserFeignClient.login(loginRequest);
        if(login.getCode() != 1){
            return ResponseResult.fail(login.getCode(), login.getMessage());
        }
        PassengerUserInfo data = login.getData();
        //分发token
        Long passengerId = data.getId();
        //生成通过jwt 生成 token，以后需要登录认证的接口，都需要带上token，还有签名规则
        String subject = IdentityConstant.PASSENGER +"_"+passengerPhone+"_"+passengerId;
        String token = JwtUtil.createToken(subject, new Date());
        UserAuthResponse response = new UserAuthResponse();
        response.setToken(token);
        return ResponseResult.success(response);
    }
}
