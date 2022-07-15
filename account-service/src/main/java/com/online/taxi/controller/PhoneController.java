package com.online.taxi.controller;

import com.online.taxi.dto.ResponseResult;
import com.online.taxi.request.PhoneRequest;
import com.online.taxi.service.PhoneService;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 15:56
 * @Description: com.online.taxi.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/phone")
@RequiredArgsConstructor
public class PhoneController {

    @NotNull
    private PhoneService phoneService;
    /**
     * 根据ID解密手机号
     * @param request PhoneRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/getPhoneList")
    public ResponseResult getPhoneByList(@RequestBody PhoneRequest request){
        return phoneService.getDecrypyById(request);
    }
    /**
     * 加密手机号
     * @param request PhoneRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/createEncrypt")
    public ResponseResult createEncrypt(@RequestBody PhoneRequest request){
        return phoneService.creatEncrypt(request);
    }
    /**
     * 根据加密手机号解密
     * @param request PhoneRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/getPhoneByEncryptList")
    public ResponseResult getPhoneByEncryptList(@RequestBody PhoneRequest request){
        return phoneService.getPhoneByEncryptList(request);
    }
}
