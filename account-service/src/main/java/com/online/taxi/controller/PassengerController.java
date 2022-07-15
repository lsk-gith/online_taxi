package com.online.taxi.controller;

import com.online.taxi.constant.AccountStatusCode;
import com.online.taxi.cosntant.BusinessInterfaceStatus;
import com.online.taxi.entity.PassengerInfo;
import com.online.taxi.request.GetTokenRequest;
import com.online.taxi.request.PassengerInfoExtRequest;
import com.online.taxi.request.PassengerInfoRequest;
import com.online.taxi.service.PassengerAddressService;
import com.online.taxi.service.PassengerInfoService;
import com.online.taxi.service.PassengerRegisterHandleService;
import com.online.taxi.cosntant.IdentityEnum;
import com.online.taxi.dto.ResponseResult;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Pattern;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 10:24
 * @Description: com.online.taxi.accountservice.controller
 * @version: 1.0
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/passenger")
public class PassengerController {

    @NotNull
    private PassengerRegisterHandleService passengerRegisterHandleService;

    @NotNull
    private PassengerInfoService passengerInfoService;

    @NotNull
    private PassengerAddressService passengerAddressService;

    private static final int NUM = 11;

    /**
     * 乘客登录
     * @param request GetTokenRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/regist")
    public ResponseResult getVerificationCode(@RequestBody GetTokenRequest request) throws Exception{
        try {
            String phoneNum = request.getPhoneNum();
            if(StringUtils.isBlank(phoneNum)){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_EMPTY.getCode(),AccountStatusCode.PHONE_NUM_EMPTY.getValue());
            }
            if(NUM != phoneNum.length()){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_DIGIT.getCode(),AccountStatusCode.PHONE_NUM_DIGIT.getValue());
            }
            if(!Pattern.compile(AccountStatusCode.PHONE_NUMBER_VERIFICATION.getValue()).matcher(phoneNum).matches()){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_ERROR.getCode(), AccountStatusCode.PHONE_NUM_ERROR.getValue());
            }
            request.setIdentityStatus(IdentityEnum.PASSENGER.getCode());
            log.info("手机号：" + phoneNum + "");
            return passengerRegisterHandleService.handle(request);
        }catch (Exception e){
            log.error("操作异常",e);
            e.printStackTrace();
            return ResponseResult.fail(1, "操作异常", request.getPhoneNum());
        }
    }

    /**
     * 查询乘客详情
     * @param request GetTokenRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/passengerInfo")
    public ResponseResult getPassengerInfo(@RequestBody GetTokenRequest request){
        return ResponseResult.success(passengerInfoService.getPassengerInfoView(request));
    }

    /**
     * 修改乘客信息
     * @param request PassengerInfoRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/updatePassengerInfo")
    public ResponseResult updatePassengerInfo(@RequestBody PassengerInfoRequest request){
        ResponseResult result;
        if(null != request.getId()){
            if(null != request.getData()){
                if(null != request.getData().getPassengerInfo()){
                    request.getData().getPassengerInfo().setId(request.getId());
                }
                if(null != request.getData().getPassengerAddress()){
                    request.getData().getPassengerAddress().setPassengerInfoId(request.getId());
                }
            }
        }
        if(null != request.getData()){
            if(null != request.getData().getPassengerAddress()){
                result = passengerAddressService.updatePassengerAddress(request.getData().getPassengerAddress());
                if(BusinessInterfaceStatus.SUCCESS.getCode() != result.getCode()){
                    return result;
                }
            }

            if(null != request.getData().getPassengerInfo()){
                result = passengerInfoService.updatePassengerInfo(request.getData().getPassengerInfo());
                if(BusinessInterfaceStatus.SUCCESS.getCode() != result.getCode()){
                    return result;
                }
            }

        }


        log.info("修改乘客信息成功");
        return ResponseResult.success();
    }


    /**
     * 修改乘客额外信息
     * @param request
     * @return
     */
    @PostMapping("/ext")
    public ResponseResult updatePassengerInfoExt(@RequestBody PassengerInfoExtRequest request){
        Integer id = request.getId();
        if(id == null ){
            return ResponseResult.fail(BusinessInterfaceStatus.FAIL.getCode(),"乘客id为空");

        }
        Integer isContact = request.getIsContact();
        Integer isShare = request.getIsShare();
        String sharingTime = request.getSharingTime();
        if(null == isContact && null == isShare && StringUtils.isBlank(sharingTime)){
            return ResponseResult.fail(BusinessInterfaceStatus.FAIL.getCode(),"乘客信息为空");

        }

        PassengerInfo passengerInfo = new PassengerInfo();
        passengerInfo.setId(id);
        if(null != isContact){
            passengerInfo.setIsContact(isContact);
        }
        if(null != isShare){
            passengerInfo.setIsShare(isShare);
        }
        if(StringUtils.isNotBlank(sharingTime)){
            passengerInfo.setSharingTime(sharingTime);
        }
        int row = passengerInfoService.updatePassengerInfoById(passengerInfo);
        if(row > 0){
            return ResponseResult.success("");
        }else {
            return ResponseResult.fail("无可更新的乘客额外信息");
        }


    }






}
