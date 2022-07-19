package com.online.taxi.controller;

import com.online.taxi.constant.AccountStatusCode;
import com.online.taxi.dao.DriverInfoDao;
import com.online.taxi.dto.DriverBaseInfoView;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.entity.EncriptUtil;
import com.online.taxi.request.*;
import com.online.taxi.service.DriverInfoService;
import com.online.taxi.service.DriverRegistHandleService;
import com.online.taxi.service.DriverWorkStatusHandleService;
import com.online.taxi.util.DriverinfoValidator;
import com.sun.istack.internal.NotNull;
import lombok.NonNull;
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
 * @Date: 2022/7/18 - 07 - 18 - 22:18
 * @Description: com.online.taxi.controller
 * @version: 1.0
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverController {
    @NotNull
    private DriverInfoService driverInfoService;
    @NotNull
    private DriverRegistHandleService driverRegistHandleService;
    @NotNull
    private DriverWorkStatusHandleService driverWorkStatusHandleService;
    @NonNull
    private DriverInfoDao driverInfoDao;

    private static final int NUM = 11;


    @PostMapping(value = "/regist")
    public ResponseResult getVerificationDriverCode(@RequestBody GetTokenRequest request){

        try {
            String phoneNumber = request.getPhoneNum();
            if(StringUtils.isEmpty(phoneNumber)){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_EMPTY.getCode(), AccountStatusCode.PHONE_NUM_EMPTY.getValue());
            }
            if(phoneNumber.length() != NUM){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_DIGIT.getCode(), AccountStatusCode.PHONE_NUM_DIGIT.getValue());
            }
            if(!Pattern.compile(AccountStatusCode.PHONE_NUMBER_VERIFICATION.getValue()).matcher(phoneNumber).matches()){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_ERROR.getCode(), AccountStatusCode.PHONE_NUM_ERROR.getValue());
            }
            // 检查司机状态
            String strPhoneNum = EncriptUtil.toHexString(EncriptUtil.encrypt(phoneNumber));
            DriverInfo driverInfo = driverInfoService.queryDriverInfoByPhoneNum(strPhoneNum);
            ResponseResult errResponse = DriverinfoValidator.hasError(phoneNumber, driverInfo);
            if(null != errResponse){
                return errResponse;
            }
            return driverRegistHandleService.checkIn(request);
        }catch (Exception e){
            log.error("服务器异常",e);
            e.printStackTrace();
            return ResponseResult.fail(1, "服务器异常", request.getPhoneNum());
        }

    }

    /**
     * 修改司机工作状态
     * @param request 对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/changeWorkStatus")
    public ResponseResult changWorkStatus(@RequestBody DriverWorkStatusRequest request){
        Integer id = request.getId();
        if(null == id || 0 == id){
            return ResponseResult.fail(-1, "longitude:主键id为空");
        }
        request.setId(id);
        Double longitude = request.getLongitude();
        if(null == longitude){
            return ResponseResult.fail(AccountStatusCode.LONGITUDE_EMPTY.getCode(),AccountStatusCode.LONGITUDE_EMPTY.getValue());
        }
        Double latitude = request.getLatitude();
        if(null == latitude){
            return ResponseResult.fail(AccountStatusCode.LATITUDE_EMPTY.getCode(),AccountStatusCode.LATITUDE_EMPTY.getValue());
        }
        String city = request.getCity();
        if(StringUtils.isEmpty(city)){
            return ResponseResult.fail(AccountStatusCode.CITY_CODE_EMPTY.getCode(), AccountStatusCode.CITY_CODE_EMPTY.getValue());
        }
        Double speed = request.getSpeed();
        if(null == speed){
            return ResponseResult.fail(AccountStatusCode.SPEED_EMPTY.getCode(),AccountStatusCode.SELECT_FAIL.getValue());
        }
        log.info("请求参数："+
                "isFollowing:"+request.getIsFollowing()+
                "workStatus:" +request.getWorkStatus()+
                "csWorkStatus:" +request.getCsWorkStatus()+
                "latitude:"+ request.getLatitude()+
                "longitude:"+ request.getLongitude()+
                "city:"+ request.getCity()+
                "id:"+ request.getId() +
                "speed:" + request.getSpeed());

        return driverWorkStatusHandleService.changeWorkStatus(request);
    }

    /**
     * 添加司机
     * @param request DriverChangeRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/add")
    public ResponseResult driverAdd(@RequestBody DriverChangeRequest request){
        DriverBaseInfoView driverBaseInfoView = request.getData();
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverInfo().getCityCode())) {
            log.error("服务城市为空");
            return ResponseResult.fail(AccountStatusCode.CITY_CODE_EMPTY.getCode(),AccountStatusCode.CITY_CODE_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverInfo().getDriverLeader()) {
            log.error("司机主管为空");
            return ResponseResult.fail(AccountStatusCode.DRIVER_LEADER_EMPTY.getCode(),AccountStatusCode.DRIVER_LEADER_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverInfo().getGender()) {
            log.error("司机性别为空");
            return ResponseResult.fail(AccountStatusCode.GENDER_EMPTY.getCode(),AccountStatusCode.GENDER_EMPTY.getValue());
        }
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverInfo().getDriverName())) {
            log.error("司机姓名为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_NAME_EMPTY.getCode(), AccountStatusCode.DRIVER_NAME_EMPTY.getValue());
        }
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverLicenceInfo().getIdentityCardId())) {
            log.error("司机身份证为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_CARD_ID_EMPTY.getCode(),AccountStatusCode.DRIVER_CARD_ID_EMPTY.getValue());
        }
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverInfo().getPhoneNumber())) {
            log.error("司机手机号为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_PHONE_NUM_EMPTY.getCode(),AccountStatusCode.DRIVER_PHONE_NUM_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverBaseInfo().getContractEndDate()) {
            log.error("合同协议有效期止为空！");
            return ResponseResult.fail(AccountStatusCode.CONTRACT_END_DATE_EMPTY.getCode(),AccountStatusCode.CONTRACT_END_DATE_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverBaseInfo().getContractStartDate()) {
            log.error("合同协议有效期始为空！");
            return ResponseResult.fail(AccountStatusCode.CONTRACT_START_DATE_EMPTY.getCode(),AccountStatusCode.CONTRACT_START_DATE_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverInfo().getUseStatus()) {
            log.error("启用状态为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_USE_STATUS.getCode(),AccountStatusCode.DRIVER_USE_STATUS.getValue());
        }
        return driverInfoService.changeDriverBaseInfo(driverBaseInfoView, 1);
    }
    /**
     * 修改司机
     * @param request DriverChangeRequest对象
     * @return ResponseResult实例
     */
    @PostMapping(value = "/changeDriver")
    public ResponseResult driverChange(@RequestBody DriverChangeRequest request){
        DriverBaseInfoView driverBaseInfoView = request.getData();
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverInfo().getCityCode())) {
            log.error("服务城市为空");
            return ResponseResult.fail(AccountStatusCode.CITY_CODE_EMPTY.getCode(),AccountStatusCode.CITY_CODE_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverInfo().getDriverLeader()) {
            log.error("司机主管为空");
            return ResponseResult.fail(AccountStatusCode.DRIVER_LEADER_EMPTY.getCode(),AccountStatusCode.DRIVER_LEADER_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverInfo().getGender()) {
            log.error("司机性别为空");
            return ResponseResult.fail(AccountStatusCode.GENDER_EMPTY.getCode(),AccountStatusCode.GENDER_EMPTY.getValue());
        }
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverInfo().getDriverName())) {
            log.error("司机姓名为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_NAME_EMPTY.getCode(), AccountStatusCode.DRIVER_NAME_EMPTY.getValue());
        }
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverLicenceInfo().getIdentityCardId())) {
            log.error("司机身份证为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_CARD_ID_EMPTY.getCode(),AccountStatusCode.DRIVER_CARD_ID_EMPTY.getValue());
        }
        if (org.springframework.util.StringUtils.isEmpty(driverBaseInfoView.getDriverInfo().getPhoneNumber())) {
            log.error("司机手机号为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_PHONE_NUM_EMPTY.getCode(),AccountStatusCode.DRIVER_PHONE_NUM_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverBaseInfo().getContractEndDate()) {
            log.error("合同协议有效期止为空！");
            return ResponseResult.fail(AccountStatusCode.CONTRACT_END_DATE_EMPTY.getCode(),AccountStatusCode.CONTRACT_END_DATE_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverBaseInfo().getContractStartDate()) {
            log.error("合同协议有效期始为空！");
            return ResponseResult.fail(AccountStatusCode.CONTRACT_START_DATE_EMPTY.getCode(),AccountStatusCode.CONTRACT_START_DATE_EMPTY.getValue());
        }
        if (null == driverBaseInfoView.getDriverInfo().getUseStatus()) {
            log.error("启用状态为空！");
            return ResponseResult.fail(AccountStatusCode.DRIVER_USE_STATUS.getCode(),AccountStatusCode.DRIVER_USE_STATUS.getValue());
        }
        return driverInfoService.changeDriverBaseInfo(driverBaseInfoView, 2);
    }


    /**
     * 查询司机详情
     * @param request DriverChangeRequest对象
     * @return ResponseResult 实例
     */
    @PostMapping(value = "/driverInfo")
    public ResponseResult driverInfo(@RequestBody DriverChangeRequest request) {
        return ResponseResult.success(driverInfoService.getDriverBaseInfoView(request.getId()));
    }

    /**
     * 修改司机地址信息
     */
    @PostMapping(value = "/updateDriverAddress")
    public ResponseResult updateDriverAddress(@RequestBody UpdateDriverAddressRequest request) {
        if(null == request.getId() ){
            return ResponseResult.fail(AccountStatusCode.ID_EMPTY.getCode(),AccountStatusCode.ID_EMPTY.getValue());
        }
        if(org.springframework.util.StringUtils.isEmpty(request.getAddress())){
            return ResponseResult.fail(AccountStatusCode.ADDRESS_EMPTY.getCode(),AccountStatusCode.ADDRESS_EMPTY.getValue());
        }
        if(org.springframework.util.StringUtils.isEmpty(request.getAddressLongitude())){
            return ResponseResult.fail(AccountStatusCode.LONGITUDE_EMPTY.getCode(),AccountStatusCode.LONGITUDE_EMPTY.getValue());
        }
        if(org.springframework.util.StringUtils.isEmpty(request.getAddressLatitude())){
            return ResponseResult.fail(AccountStatusCode.LATITUDE_EMPTY.getCode(),AccountStatusCode.LATITUDE_EMPTY.getValue());
        }
        if(org.springframework.util.StringUtils.isEmpty(request.getPhoneNumber())){
            return  ResponseResult.fail(AccountStatusCode.PHONE_NUM_EMPTY.getCode(),AccountStatusCode.PHONE_NUM_EMPTY.getValue());
        }
        return driverInfoService.updateDriverAddressRequest(request);
    }
    /**
     * 冻结司机
     * @param request 请求状态
     * @return ResponseResult实例
     */
    @PostMapping(value = "/updateDriverStatus")
    public ResponseResult updateDriverStatus(@RequestBody UpdateDriverStatusRequest request){
        DriverInfo driverInfo = new DriverInfo();
        int update  ;
        if(null != request.getId() ){
            driverInfo.setId(request.getId());
        }else {
            return  ResponseResult.fail(AccountStatusCode.ID_EMPTY.getCode(),AccountStatusCode.ID_EMPTY.getValue());
        }
        if(null != request.getUseStatus()){
            driverInfo.setUseStatus(request.getUseStatus());
        }
        if(null != request.getSignStatus()){
            driverInfo.setSignStatus(request.getSignStatus());
        }
        if(null != request.getCarId()){
            if(0 == request.getCarId()){
                driverInfo.setCarId(null);
                update =  driverInfoService.updateCarIdById(driverInfo);
            }else {
                driverInfo.setCarId(request.getCarId());
                // 一个司机对应一辆车 根据车辆id查询司机信息，如果司机id不等于查出来的车辆id,则车辆id重复
                DriverInfo driverInfoUpdate = driverInfoDao.queryDriverInfoByCarId(driverInfo.getCarId());
                if( null != driverInfoUpdate){
                    if(driverInfoUpdate.getId().intValue() != driverInfo.getId().intValue()){
                        return ResponseResult.fail(AccountStatusCode.VEHICLE_REPEAT.getCode(), AccountStatusCode.VEHICLE_REPEAT.getValue(), String.valueOf(driverInfo.getCarId()));
                    }
                }
                update =  driverInfoService.updateByPrimaryKeySelective(driverInfo);
            }
        }else {
            update =  driverInfoService.updateByPrimaryKeySelective(driverInfo);
        }
        if(0==update){
            log.error("修改失败");
            return ResponseResult.fail(1,"修改失败");
        }else {
            log.info("修改成功");
            return ResponseResult.success("");
        }
    }
    @PostMapping(value = "/addressDecryption")
    public ResponseResult addressDecryption(@RequestBody DriverChangeRequest request){
        String addressDecry = EncriptUtil.decryptionPhoneNumber(request.getAddress());
        return ResponseResult.success(addressDecry);
    }

}
