package com.online.taxi.service.impl;

import com.online.taxi.constant.AccountStatusCode;
import com.online.taxi.dao.DriverBaseInfoDao;
import com.online.taxi.dao.DriverInfoDao;
import com.online.taxi.dao.DriverLicenceInfoDao;
import com.online.taxi.dto.DriverBaseInfoView;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.DriverBaseInfo;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.entity.DriverLicenceInfo;
import com.online.taxi.entity.EncriptUtil;
import com.online.taxi.mapper.DriverBaseInfoMapper;
import com.online.taxi.request.UpdateDriverAddressRequest;
import com.online.taxi.service.DriverInfoCacheService;
import com.online.taxi.service.DriverInfoService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 17:17
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DriverInfoServiceImpl implements DriverInfoService {
    @NonNull
    private DriverInfoDao driverInfoDao;

    @NonNull
    private DriverInfoCacheService driverInfoCacheService;

    @NonNull
    private DriverLicenceInfoDao driverLicenceInfoDao;

    @NonNull
    private DriverBaseInfoDao driverBaseInfoDao;


    @Override
    public DriverInfo queryDriverInfoByPhoneNum(String phoneNum) {
        return driverInfoDao.queryDriverInfoByPhoneNum(phoneNum);
    }

    @Override
    public int updateByPrimaryKeySelective(DriverInfo record) {
        return driverInfoDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DriverInfo record) {
        return driverInfoDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateCarIdById(DriverInfo record) {
        return driverInfoDao.updateCarIdById(record);
    }


    /**
     * 修改司机信息
     * @param driverInfo 对象
     * @return int
     */
    @Override
    public int updateDriverInfoByPhoneNum(DriverInfo driverInfo) {
        int code = driverInfoDao.updateDriverInfoByPhoneNum(driverInfo);
        //改变司机缓存中状态
        driverInfoCacheService.put(driverInfo.getPhoneNumber(), JSONObject.fromObject(driverInfo).toString());
        return code;
    }
    /**
     * 修改或者添加司机信息
     * @param driverBaseInfoView 对象
     * @param type 1为添加 ，2 为修改
     * @return ResponseResult实例
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult changeDriverBaseInfo(DriverBaseInfoView driverBaseInfoView, int type) {
        DriverInfo driverInfo = new DriverInfo();
        DriverBaseInfo driverBaseInfo = new DriverBaseInfo();
        DriverLicenceInfo driverLicenceInfo = new DriverLicenceInfo();
        if(null != driverBaseInfoView.getDriverInfo()){
            BeanUtils.copyProperties(driverBaseInfoView.getDriverInfo(), driverInfo);
        }else{
            return ResponseResult.fail(1, "driverInfo为空！");
        }
        if(null != driverBaseInfoView.getDriverBaseInfo()){
            BeanUtils.copyProperties(driverBaseInfoView.getDriverBaseInfo(), driverBaseInfo);
        }else {
            return ResponseResult.fail(1, "driverBaseInfo为空！");
        }
        if(null != driverBaseInfoView.getDriverLicenceInfo()){
            BeanUtils.copyProperties(driverBaseInfoView.getDriverLicenceInfo(), driverLicenceInfo);
        }else{
            return ResponseResult.fail(1, "driverLicenceInfo为空！");
        }

        if(AccountStatusCode.ADD.getCode() == type){
            if(null != driverInfo.getCarId()){
                // 如果车辆ID为0 ，设置为null.
                if(0 == driverInfo.getCarId()){
                    driverInfo.setCarId(null);
                }else{
                    // 一个司机对应一辆车
                    DriverInfo driverInfo1 = driverInfoDao.queryDriverInfoByCarId(driverInfo.getCarId());
                    if(null != driverInfo1){
                        return ResponseResult.fail(AccountStatusCode.VEHICLE_REPEAT.getCode(), AccountStatusCode.VEHICLE_REPEAT.getValue());
                    }
                }
            }
            String phone = EncriptUtil.toHexString(EncriptUtil.encrypt(driverBaseInfoView.getDriverInfo().getPhoneNumber())).toUpperCase();
            if(null != driverInfoDao.queryDriverInfoByPhoneNum(phone)){
                return ResponseResult.fail(AccountStatusCode.PHONE_NUM_REPEAT.getCode(), AccountStatusCode.PHONE_NUM_REPEAT.getValue());
            }
            driverInfo.setUpdateTime(new Date());
            driverInfo.setRegisterTime(new Date());
            //司机录入时账户为0
            driverInfo.setBalance(new BigDecimal(0));
            String strPhoneNum = null;
            String networkReservationTaxiDriverLicenseNumber = null;
            String address = null;
            String driverLicenseNum = null;
            try {
                if(!StringUtils.isEmpty(driverInfo.getPhoneNumber())){
                    strPhoneNum = EncriptUtil.encryptionPhoneNumber(driverInfo.getPhoneNumber());
                }
                if(!StringUtils.isEmpty(driverBaseInfo.getNetworkReservationTaxiDriverLicenseNumber())){
                    networkReservationTaxiDriverLicenseNumber = EncriptUtil.encryptionPhoneNumber(driverBaseInfo.getNetworkReservationTaxiDriverLicenseNumber());
                }
                if(!StringUtils.isEmpty(driverBaseInfo.getAddress())){
                    address = EncriptUtil.encryptionPhoneNumber(driverBaseInfo.getAddress());
                }
                if(!StringUtils.isEmpty(driverBaseInfo.getDriverLicense())){
                    driverLicenseNum = EncriptUtil.encryptionPhoneNumber(driverBaseInfo.getDriverLicense());
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            driverInfo.setPhoneNumber(strPhoneNum);
            driverInfo.setCreateTime(new Date());
            int driverInfoInsert = driverInfoDao.insert(driverInfo);
            if(1 != driverInfoInsert){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseResult.fail(1, "添加driverInfo失败！");
            }
            int driverId = driverInfo.getId();
            driverBaseInfoView.getDriverBaseInfo().setId(driverInfo.getId());
            driverLicenceInfo.setDriverId(driverId);
            driverBaseInfo.setId(driverId);
            driverLicenceInfo.setCreateTime(new Date());
            int driverLicenceInfoInsert = driverLicenceInfoDao.insertSelective(driverLicenceInfo);
            if(1 != driverLicenceInfoInsert){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseResult.fail(1, "添加driverLicenceInfoInsert失败！");
            }
            driverBaseInfo.setNetworkReservationTaxiDriverLicenseNumber(networkReservationTaxiDriverLicenseNumber);
            driverBaseInfo.setAddress(address);
            driverBaseInfo.setDriverLicense(driverLicenseNum);
            driverBaseInfo.setCreateTime(new Date());
            int driverBaseInfoInsert = driverBaseInfoDao.insertSelective(driverBaseInfo);
            if(1 != driverBaseInfoInsert){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ResponseResult.fail(1, "添加driverBaseInfoInsert失败！");
            }
            address  = EncriptUtil.decryptionPhoneNumber(address);
            driverBaseInfo.setAddress(address);
            driverBaseInfoView.setDriverInfo(driverInfo);
            driverBaseInfoView.setDriverBaseInfo(driverBaseInfo);
            driverBaseInfoView.setDriverLicenceInfo(driverLicenceInfo);

        }else if(AccountStatusCode.UPDATE.getCode() == type){
            String strPhoneNum = driverInfo.getPhoneNumber();
            String networkReservationTaxiDriverLicenseNumber = driverBaseInfo.getNetworkReservationTaxiDriverLicenseNumber();
            String address = driverBaseInfo.getAddress();
            String driverLicenceNum = driverBaseInfo.getDrivingLicenceNumber();
            if(null != driverInfo.getCarId()){
                // 车辆id 为0 设置为空。解绑
                if(0 == driverInfo.getCarId()){
                    driverInfo.setCarId(null);
                    int update = driverInfoDao.updateCarIdById(driverInfo);
                    if(0 == update){
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        return ResponseResult.fail(1, "解绑车辆失败");
                    }
                }else {
                    // 一个司机对应一辆车 根据车辆id查询司机信息，如果司机id不等于查出来的车辆id,则车辆id重复
                    DriverInfo driverInfoUpdate = driverInfoDao.queryDriverInfoByCarId(driverInfo.getCarId());
                    if(null != driverInfoUpdate){
                        if(driverInfoUpdate.getId().intValue() != driverInfo.getId().intValue()){
                            return ResponseResult.fail(AccountStatusCode.VEHICLE_REPEAT.getCode(), AccountStatusCode.VEHICLE_REPEAT.getValue());
                        }
                    }
                }
            }

            if(!StringUtils.isEmpty(driverInfo.getPhoneNumber())){
                strPhoneNum = EncriptUtil.toHexString(EncriptUtil.encrypt(strPhoneNum)).toUpperCase();
            }
            if(!StringUtils.isEmpty(networkReservationTaxiDriverLicenseNumber)){
                networkReservationTaxiDriverLicenseNumber = EncriptUtil.encryptionPhoneNumber(networkReservationTaxiDriverLicenseNumber);
            }
            if(!StringUtils.isEmpty(address)){
                address = EncriptUtil.encryptionPhoneNumber(address);
            }
            if(!StringUtils.isEmpty(driverLicenceNum)){
                driverLicenceNum = EncriptUtil.encryptionPhoneNumber(driverLicenceNum);
            }

            if(null != driverBaseInfoView.getDriverInfo()){
                driverInfo.setPhoneNumber(strPhoneNum);
                int update = driverInfoDao.updateByPrimaryKeySelective(driverInfo);
                if(0== update){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return ResponseResult.fail(1,"修改driverInfo失败");
                }
            }

            if(null != driverBaseInfoView.getDriverBaseInfo()){
                driverBaseInfo.setNetworkReservationTaxiDriverLicenseNumber(networkReservationTaxiDriverLicenseNumber);;
                driverBaseInfo.setAddress(address);
                driverBaseInfo.setDrivingLicenceNumber(driverLicenceNum);
                int update = driverBaseInfoDao.updateByPrimaryKeySelective(driverBaseInfo);
                if(0== update){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return ResponseResult.fail(1,"修改driverBaseInfo失败");
                }
            }
            if(null != driverBaseInfoView.getDriverLicenceInfo()){
                int update = driverLicenceInfoDao.updateByDriverIdSelective(driverBaseInfoView.getDriverLicenceInfo());
                if(0== update){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return ResponseResult.fail(1,"修改driverLicenceInfo失败");
                }
            }
        }

        return ResponseResult.success(driverBaseInfoView);
    }
    /**
     * 通过司机id 查询司机信息
     * @param driverId 司机id
     * @return HashMap<String, Object>
     */
    @Override
    public HashMap<String, Object> getDriverBaseInfoView(int driverId) {
        HashMap<String, Object> view = new HashMap<>();
        DriverInfo driverInfo = driverInfoDao.selectByPrimaryKey(driverId);
        DriverLicenceInfo driverLicenceInfo = driverLicenceInfoDao.selectByDriverId(driverId);
        DriverBaseInfo driverBaseInfo = driverBaseInfoDao.selectByPrimaryKey(driverId);
        if(null != driverInfo){
            String strPhoneNum = EncriptUtil.decryptionPhoneNumber(driverInfo.getPhoneNumber());
            driverInfo.setPhoneNumber(strPhoneNum);
            view.put("driverInfo", driverInfo);
        }
        if(null != driverLicenceInfo){
            view.put("driverLicenceInfo", driverLicenceInfo);
        }
        if(null != driverBaseInfo){
            if(org.apache.commons.lang.StringUtils.isNotBlank(driverBaseInfo.getNetworkReservationTaxiDriverLicenseNumber())){
                String networkReservationTaxiDriverLicenseNumber = EncriptUtil.decryptionPhoneNumber(driverBaseInfo.getNetworkReservationTaxiDriverLicenseNumber());
                driverBaseInfo.setNetworkReservationTaxiDriverLicenseNumber(networkReservationTaxiDriverLicenseNumber);
            }
            if(org.apache.commons.lang.StringUtils.isNotBlank(driverBaseInfo.getAddress())){
                String address = EncriptUtil.decryptionPhoneNumber(driverBaseInfo.getAddress());
                driverBaseInfo.setAddress(address);
            }
            if(org.apache.commons.lang.StringUtils.isNotBlank(driverBaseInfo.getDrivingLicenceNumber())){
                String driverLicenceNum = EncriptUtil.decryptionPhoneNumber(driverBaseInfo.getDrivingLicenceNumber());
                driverBaseInfo.setDrivingLicenceNumber(driverLicenceNum);
            }
            view.put("driverDaseInfo", driverBaseInfo);
        }



        return view;
    }
    /**
     * 修改司机家庭地址信息
     * @param request 地址信息
     * @return ResponseResult实例
     */
    @Override
    public ResponseResult updateDriverAddressRequest(UpdateDriverAddressRequest request) {
        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setId(request.getId());
        String strPhone = EncriptUtil.encryptionPhoneNumber(request.getPhoneNumber());
        if(!StringUtils.isEmpty(strPhone)){
            driverInfo.setPhoneNumber(strPhone);
        }else {
            driverInfo.setPhoneNumber(request.getPhoneNumber());
        }
        int updateDriverInfo = driverInfoDao.updateByPrimaryKey(driverInfo);

        if(0 == updateDriverInfo){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.fail(1,"修改driverInfo失败");
        }
        String address = EncriptUtil.encryptionPhoneNumber(request.getAddress());
        DriverBaseInfo driverBaseInfo = new DriverBaseInfo();
        driverBaseInfo.setAddress(address);
        driverBaseInfo.setId(request.getId());
        driverBaseInfo.setAddressLatitude(request.getAddressLatitude());
        driverBaseInfo.setAddressLongitude(request.getAddressLongitude());
        int update = driverBaseInfoDao.updateByPrimaryKeySelective(driverBaseInfo);
        if(0 == update){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResponseResult.fail(1,"修改DriverBaseInfo失败");
        }
        return ResponseResult.success("");
    }


}
