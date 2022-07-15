package com.online.taxi.service.impl;

import com.online.taxi.constant.AccountStatusCode;
import com.online.taxi.cosntant.IdentityEnum;
import com.online.taxi.dao.DriverInfoDao;
import com.online.taxi.dao.PassengerInfoDao;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.entity.EncriptUtil;
import com.online.taxi.entity.PassengerInfo;
import com.online.taxi.request.PhoneRequest;
import com.online.taxi.service.IdRedisService;
import com.online.taxi.service.PhoneService;
import com.sun.istack.internal.NotNull;
import com.sun.org.apache.bcel.internal.generic.DREM;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 14:24
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {
    @NotNull
    private DriverInfoDao driverInfoDao;

    @NotNull
    private PassengerInfoDao passengerInfoDao;

    @NotNull
    private IdRedisService idRedisService;

    private static final Integer EXP_SECONDS = 120;

    /**
     * 通过id解密手机号
     * @param request id,idType
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult getDecrypyById(PhoneRequest request) {
        Integer idType = request.getIdType();
        if(null == idType){
            log.error("idType为空！");
            return ResponseResult.fail(1, "idType为空！");
        }
        if(null == request.getInfoList()){
            log.error("infoList为空！");
            return ResponseResult.fail(1, "infoList为空！");
        }
        if(ObjectUtils.nullSafeEquals(idType, IdentityEnum.PASSENGER.getCode())){
            List<PassengerInfo> passengerInfos = passengerInfoDao.selectByPrimaryKeyList();
            for(PassengerInfo passengerInfo : passengerInfos){
                idRedisService.push(idType, passengerInfo.getId(), passengerInfo.getPhone(), EXP_SECONDS);
            }
        }
        if(ObjectUtils.nullSafeEquals(idType, IdentityEnum.DRIVER.getCode())){
            List<DriverInfo> driverInfos = driverInfoDao.selectByPrimaryKeyList();
            for(DriverInfo driverInfo : driverInfos){
                idRedisService.push(idType, driverInfo.getId(), driverInfo.getPhoneNumber(), EXP_SECONDS);
            }
        }

        for(int i = 0; i < request.getInfoList().size(); i++){
            String strPhone = "";
            if(null != request.getInfoList().get(i)){
                if(!StringUtils.isEmpty(idRedisService.pull(idType, request.getInfoList().get(i).getId()))){
                    strPhone = EncriptUtil.decryptionPhoneNumber(idRedisService.pull(idType, request.getInfoList().get(i).getId()));
                }
            }
            request.getInfoList().get(i).setPhone(strPhone);
        }

        return ResponseResult.success(request);
    }



    /**
     * 加密手机号
     * @param request  手机号数组
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult creatEncrypt(PhoneRequest request) {
        if(null == request){
            log.error("手机号数组为空");
            return ResponseResult.fail(AccountStatusCode.PHONE_NUM_EMPTY.getCode(), AccountStatusCode.PHONE_NUM_EMPTY.getValue());
        }

        for(int i = 0; i < request.getInfoList().size(); i++){
            String strPhone = "";
            if(null == request.getInfoList().get(i).getPhone()){
                log.error("手机号为空");
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_EMPTY.getCode(), AccountStatusCode.PHONE_NUM_EMPTY.getValue());
            }
            strPhone = EncriptUtil.encryptionPhoneNumber(request.getInfoList().get(i).getPhone());
            if(StringUtils.isEmpty(strPhone)){
                request.getInfoList().get(i).setEncrypt(request.getInfoList().get(i).getPhone());
            }else {
                request.getInfoList().get(i).setEncrypt(strPhone);
            }
        }


        return ResponseResult.success(request);
    }


    /**
     * 通过密文解密手机号
     * @param request 密文数组
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult getPhoneByEncryptList(PhoneRequest request) {
        if(null == request){
            log.error("密文数组为空");
            return ResponseResult.fail(AccountStatusCode.PHONE_NUM_EMPTY.getCode(), AccountStatusCode.PHONE_NUM_EMPTY.getValue());
        }
        for(int i = 0; i < request.getInfoList().size(); i++){
            String strPhone;
            if(null == request.getInfoList().get(i).getEncrypt()){
                log.info("密文为空");
                return ResponseResult.fail(AccountStatusCode.ENCRYPT_EMPTY.getCode(), AccountStatusCode.ENCRYPT_EMPTY.getValue());
            }
            strPhone = EncriptUtil.decryptionPhoneNumber(request.getInfoList().get(i).getEncrypt());
            if(StringUtils.isEmpty(strPhone)){
                request.getInfoList().get(i).setPhone(request.getInfoList().get(i).getEncrypt());
            }else {
                request.getInfoList().get(i).setPhone(strPhone);
            }
        }

        return ResponseResult.success(request);
    }
}
