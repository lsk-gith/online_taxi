package com.lsk.apipassager.feign;

import com.lsk.apipassager.feign.request.CodeVerifyRequest;
import com.lsk.common.dto.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:10
 * @Description: com.lsk.apipassager.feign
 * @version: 1.0
 */
@FeignClient(name = "SERVICE-VERIFICATION-CODE")
public interface ServiceVerificationCodeFeignClient {
    @RequestMapping(value = "/verify-code/verify",method = RequestMethod.POST)
    public ResponseResult verify(@RequestBody CodeVerifyRequest codeVerifyRequest);
}
