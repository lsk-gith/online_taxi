package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class PassengerAddress implements Serializable {
    private Integer id;

    /**
     * 乘客id
     */
    private Integer passengerInfoId;

    /**
     * 地址纬度
     */
    private Double latitude;

    /**
     * 地址经度
     */
    private Double longitude;

    /**
     * 详细地址
     */
    private String addressName;

    /**
     * 0:家，1：公司
     */
    private Integer type;

    /**
     * 地址描述
     */
    private String addressDesc;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}