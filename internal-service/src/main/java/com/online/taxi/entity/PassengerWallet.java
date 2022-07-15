package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 乘客钱包
 */
@Data
public class PassengerWallet implements Serializable {
    private Integer id;

    /**
     * 乘客Id
     */
    private Integer passengerInfoId;

    /**
     * 本金
     */
    private Double capital;

    /**
     * 赠费
     */
    private Double giveFee;

    /**
     * 冻结本金
     */
    private Double freezeCapital;

    /**
     * 冻结赠费
     */
    private Double freezeGiveFee;

    /**
     * 创建时间
     */
    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}