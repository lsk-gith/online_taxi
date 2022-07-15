package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 司机驾驶证信息
 */
@Data
public class DriverLicenceInfo implements Serializable {
    /**
     * 审核记录id
     */
    private Integer id;

    /**
     * 司机id
     */
    private Integer driverId;

    /**
     * 驾照主页照片地址
     */
    private String mainDrivingLicense;

    /**
     * 驾照副页照片地址
     */
    private String viceDrivingLicense;

    /**
     * 驾照正副页照片地址
     */
    private String allDrivingLicense;

    /**
     * 手持驾照照片地址
     */
    private String groupDrivingLicense;

    /**
     * 身份证
     */
    private String identityCardId;

    /**
     * 身份证正面照
     */
    private String mainIdcardLicense;

    /**
     * 身份证副页照片地址
     */
    private String viceIdcardLicense;

    /**
     * 手持身份证照片
     */
    private String groupIdcardLicense;

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}