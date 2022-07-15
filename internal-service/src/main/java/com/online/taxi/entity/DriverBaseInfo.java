package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class DriverBaseInfo implements Serializable {
    private Integer id;

    /**
     * 手机运营商
     */
    private String mobileOperator;

    /**
     * 公司标识
     */
    private String companyLogo;

    /**
     * 注册行政地区代码
     */
    private String administrativeCode;

    /**
     * 驾驶员出生日期
     */
    private Date birthday;

    /**
     * 国籍
     */
    private String country;

    /**
     * 驾驶员民族
     */
    private String national;

    /**
     * 驾驶证编号
     */
    private String drivingLicenceNumber;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 外语能力
     */
    private String foreignLanguageAbility;

    /**
     * 使用APP版本号
     */
    private String appVersion;

    /**
     * 使用地图类型
     */
    private String mapType;

    /**
     * 驾驶员学历
     */
    private String educationBackground;

    /**
     * 户口   登记机关名称
     */
    private String householdRegistrationAuthority;

    /**
     * 户口   住址
     */
    private String registeredPermanentResidenceAddress;

    /**
     * 现居地址
     */
    private String address;

    /**
     * 现居地址经度
     */
    private String addressLongitude;

    /**
     * 现居地址纬度
     */
    private String addressLatitude;

    /**
     * 驾驶员照片文件编号
     */
    private String driverImgFileNumber;

    /**
     * 机动车驾驶员证
     */
    private String driverLicense;

    /**
     * 机动车驾驶证扫描件文件编号
     */
    private String driverLicenseScanCopyNumber;

    /**
     * 准驾车型
     */
    private String drivingType;

    /**
     * 初次领取驾驶证日期
     */
    private Date firstGetDriverLicenseDate;

    /**
     * 驾驶证有效期起
     */
    private Date driverLicenseValidityStart;

    /**
     * 驾驶证有效期止
     */
    private Date driverLicenseValidityEnd;

    /**
     * 是否巡游出租车驾驶员
     */
    private Integer isTaxiDriver;

    /**
     * 网络预约出租汽车驾驶员证号
     */
    private String networkReservationTaxiDriverLicenseNumber;

    /**
     * 网络预约出租汽车驾驶员证发证机构
     */
    private String networkReservationTaxiDriverLicenseIssuingAgencies;

    /**
     * 资格证发证日期
     */
    private Date certificateIssuingDate;

    /**
     * 初次领取资格证日期
     */
    private Date firstQualificationDate;

    /**
     * 资格证有效期起
     */
    private Date qualificationCertificateValidityStart;

    /**
     * 资格证有效期止
     */
    private Date qualificationCertificateValidityEnd;

    /**
     * 报备日期
     */
    private Date reportedDate;

    /**
     * 是否专职驾驶员
     */
    private Integer isFullTimeDriver;

    /**
     * 是否在黑名单
     */
    private Integer isInDriverBlacklist;

    /**
     * 服务类型
     */
    private Integer serviceType;

    /**
     * 驾驶员合同（或协议）签署公司
     */
    private String company;

    /**
     * 合同开始时间
     */
    private Date contractStartDate;

    /**
     * 合同结束时间
     */
    private Date contractEndDate;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 紧急联系人电话
     */
    private String emergencyContactPhoneNumber;

    /**
     * 紧急联系人地址
     */
    private String emergencyContactAddress;

    /**
     * 培训课名称
     */
    private String trainingCourses;

    /**
     * 培训课程日期
     */
    private Date trainingCoursesDate;

    /**
     * 培训开始日期
     */
    private Date trainingCoursesStartDate;

    /**
     * 培训结束日期
     */
    private Date trainingCoursesEndDate;

    /**
     * 培训时长
     */
    private Integer trainingCoursesTime;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String bankCardNumber;

    /**
     * 备注
     */
    private String note;

    /**
     * 从业资格证照片
     */
    private String qualificationCertificateImg;

    /**
     * 其他一
     */
    private String otherImg1;

    /**
     * 其他二
     */
    private String otherImg2;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}