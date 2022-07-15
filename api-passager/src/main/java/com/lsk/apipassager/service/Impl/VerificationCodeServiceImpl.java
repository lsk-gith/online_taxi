package com.lsk.apipassager.service.Impl;

import com.lsk.apipassager.service.VerificationCodeService;
import com.lsk.common.constant.IdentityConstant;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.verficationcode.VerifyCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lsk
 * @Date: 2022/7/14 - 07 - 14 - 21:16
 * @Description: com.lsk.apipassager.service.Impl
 * @version: 1.0
 */
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    RestTemplate restTemplate;

    private final String SERVICE_VERIFICATION_CODE_SERVICE = "service-verification-code";

    @Override
    public String getCode(String phoneNumber) {
        String url = "http://"+SERVICE_VERIFICATION_CODE_SERVICE+"/verify-code/generate/"+ IdentityConstant.PASSENGER+ "/" +phoneNumber;
        ResponseResult response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<Object>(null, null), ResponseResult.class).getBody();
        if(response.getCode() == 1){
            JSONObject jsonObject = JSONObject.fromObject(response.getData().toString());
            VerifyCodeResponse result =  (VerifyCodeResponse)JSONObject.toBean(jsonObject,VerifyCodeResponse.class);
            return result.getCode();
        }else
            return "";
    }

    @Override
    public String checkCode(String phoneNumber, String code) {

        return null;
    }
}
