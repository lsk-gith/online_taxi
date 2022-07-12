package com.lsk.apidriver.controller;

import com.lsk.apidriver.service.ShortMsgService;
import com.lsk.apidriver.service.VerificationCodeService;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.ShortMsgRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 16:13
 * @Description: com.lsk.apidriver.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {
    @Autowired
    private ShortMsgService shortMsgService;
    @Resource
    private VerificationCodeService verificationCodeService;

    /*
     * 发送验证码，校验两种方式：自己注解，写validator。
     * @param shortMsgRequest
     * @return
     *
     */
    @RequestMapping("/verify-code/send")
    public ResponseResult verifyCodeSend(@RequestBody ShortMsgRequest shortMsgRequest){
        String phoneNumber = shortMsgRequest.getPhoneNumber();
        String code = verificationCodeService.getCode(phoneNumber);//获取验证码
        log.info("service-verification-code 返回的验证码：{}",code);
        return shortMsgService.send(phoneNumber, code);

    }

}
