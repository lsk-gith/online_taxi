package com.lsk.apidriver.service.impl;

import com.lsk.apidriver.service.VerificationCodeService;
import com.lsk.common.constant.IdentityConstant;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.verficationcode.VerifyCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 15:47
 * @Description: com.lsk.apidriver.service.impl
 * @version: 1.0
 */
public class VerificationCodeServiceImpl implements VerificationCodeService {
    @Autowired
    private RestTemplate restTemplate;

    private final String SERVICE_VERIFICATION_CODE_SERVICE = "service-verification-code";

    @Override
    public String getCode(String phoneNumber) {
        String url = "http://"+SERVICE_VERIFICATION_CODE_SERVICE+"/verify-code/generate/"+ IdentityConstant.DRIVER+ "/" +phoneNumber;
        //这里的生成验证码，又调用了一层服务，"http://service-verification-code/verify-code/generate/1[2]/phoneNumber"
        ResponseResult result = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<Object>(null,null),ResponseResult.class).getBody();

        if(result.getCode() == 1){
            JSONObject data = JSONObject.fromObject(result.getData().toString());
            VerifyCodeResponse response = (VerifyCodeResponse)JSONObject.toBean(data, VerifyCodeResponse.class);
            return response.getCode();
        }else
        return "";
    }

    @Override
    public String checkCode(String phoneNumber, String Code) {
        return null;
    }
}
