package com.lsk.serviceverificationcode.controller;

import com.lsk.common.dto.ResponseResult;
import com.lsk.serviceverificationcode.request.CodeVerifyRequest;
import com.lsk.serviceverificationcode.service.VerifyCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 21:27
 * @Description: com.lsk.serviceverificationcode.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerifyCodeController {
    @Autowired
    private VerifyCodeService verifyCodeService;
    /**
     * 根据身份，手机号，生成验证码
     * @param identity
     * @param phoneNumber
     * @return
     */
    public ResponseResult generate(@PathVariable("identity") int identity, @PathVariable("phoneNumber") String phoneNumber){
        return verifyCodeService.generate(identity, phoneNumber);
    }

    public ResponseResult verify(@RequestBody CodeVerifyRequest codeVerifyRequest){
        String phoneNumber = codeVerifyRequest.getPhoneNumber();
        int identity = codeVerifyRequest.getIdentity();
        String code = codeVerifyRequest.getCode();
        return verifyCodeService.verify(identity, phoneNumber, code);
    }


}
