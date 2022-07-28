package com.online.taxi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 计费规则表
 */
@Data
public class ChargeRule implements Serializable {
    private Integer id;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 服务类型
     */
    private Integer serviceTypeId;

    /**
     * 渠道名称
     */
    private Integer channelId;

    /**
     * 车辆级别
     */
    private Integer carLevelId;

    /**
     * 基础价
     */
    private BigDecimal lowestPrice;

    /**
     * 起步价
     */
    private BigDecimal basePrice;

    /**
     * 基础价格包含公里数
     */
    private BigDecimal baseKilo;

    /**
     * 基础价格包含时长数(分钟)
     */
    private BigDecimal baseMinutes;

    /**
     * 超公里单价(每公里单价)
     */
    private BigDecimal perKiloPrice;

    /**
     * 超时间单价(每分钟单价)
     */
    private BigDecimal perMinutePrice;

    /**
     * 远途起算公里
     */
    private BigDecimal beyondStartKilo;

    /**
     * 远途单价
     */
    private BigDecimal beyondPerKiloPrice;

    /**
     * 夜间时间段开始
     */
    private Date nightStart;

    /**
     * 夜间时间段结束
     */
    private Date nightEnd;

    /**
     * 夜间超公里加收单价
     */
    private BigDecimal nightPerKiloPrice;

    /**
     * 夜间超时间加收单价
     */
    private BigDecimal nightPerMinutePrice;

    /**
     * 生效时间
     */
    private Date effectiveTime;

    /**
     * 生效状态 0已失效 1未失效
     */
    private Integer activeStatus;

    /**
     * 是否不可用 0可用 1不可用
     */
    private Integer isUnuse;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 操作人id
     */
    private Integer operatorId;

    /**
     * create_time
     */
    private Date createTime;

    /**
     * update_time
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}