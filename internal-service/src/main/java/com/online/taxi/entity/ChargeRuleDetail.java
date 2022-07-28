package com.online.taxi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 计费规则时间段表
 */
@Data
public class ChargeRuleDetail implements Serializable {
    private Integer id;

    private Integer ruleId;

    /**
     * 时间段开始
     */
    private Integer start;

    /**
     * 时间段结束
     */
    private Integer end;

    /**
     * 超公里单价
     */
    private BigDecimal perKiloPrice;

    /**
     * 超时间单价
     */
    private BigDecimal perMinutePrice;

    /**
     * 是否删除 0未删除 1已删除
     */
    private Integer isDelete;

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