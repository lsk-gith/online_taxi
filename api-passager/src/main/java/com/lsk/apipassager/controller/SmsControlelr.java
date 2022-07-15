package com.lsk.apipassager.controller;

import com.lsk.apipassager.service.ShortMsgService;
import com.lsk.apipassager.service.VerificationCodeService;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.ShortMsgRequest;
import com.lsk.common.dto.verficationcode.VerifyCodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 21:47
 * @Description: com.lsk.apipassager.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsControlelr {
    @Autowired
    ShortMsgService shortMsgService;
    @Autowired
    VerificationCodeService verificationCodeService;

    /**
     * 发送验证码
     * @param shortMsgRequest
     * @return
     *
     */
    @RequestMapping("/verify-code/send")
    public ResponseResult verifyCodeSend(@RequestBody @Validated ShortMsgRequest shortMsgRequest){
        String phoneNumber = shortMsgRequest.getPhoneNumber();
        String code = verificationCodeService.getCode(phoneNumber);
        return shortMsgService.send(phoneNumber,code);
    }
}
