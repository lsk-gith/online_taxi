package com.lsk.serviceverificationcode.service.Impl;

import com.lsk.common.constant.CommonStatusEnum;
import com.lsk.common.dto.ResponseResult;
import com.lsk.common.dto.verficationcode.VerifyCodeResponse;
import com.lsk.common.util.RedisKeyUtil;
import com.lsk.serviceverificationcode.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: lsk
 * @Date: 2022/7/11 - 07 - 11 - 22:47
 * @Description: com.lsk.serviceverificationcode.service.Impl
 * @version: 1.0
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        //校验 发送时限，三挡验证，不能无限制发短信
        String code = String.valueOf((int)((Math.random()*9+1)*Math.pow(10,5)));
        //生成rediskey
        String keyPre = RedisKeyUtil.generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        //存redis，2分钟过期
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        codeRedis.set(code,120, TimeUnit.MINUTES);
        //返回
        VerifyCodeResponse result = new VerifyCodeResponse();
        result.setCode(code);

        return ResponseResult.success(result);
    }

    @Override
    public ResponseResult verify(int identity, String phoneNumber, String code) {
        //三档验证
        //生成redis key
        String keyPre = RedisKeyUtil.generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        String redisCode = codeRedis.get();
        if(StringUtils.isNotBlank(redisCode)&& StringUtils.isNotBlank(redisCode)
                && code.trim().equals(redisCode.trim()))
            return ResponseResult.success("");
        else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }

    }
}
