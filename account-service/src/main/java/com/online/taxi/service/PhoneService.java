package com.online.taxi.service;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.PhoneRequest;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 14:14
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface PhoneService {
    ResponseResult getDecrypyById(PhoneRequest request);

    ResponseResult creatEncrypt(PhoneRequest request);

    ResponseResult getPhoneByEncryptList(PhoneRequest request);

}
