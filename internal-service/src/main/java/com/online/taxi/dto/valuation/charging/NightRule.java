package com.online.taxi.dto.valuation.charging;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 21:20
 * @Description: com.online.taxi.dto.valuation夜间服务费
 * @version: 1.0
 */
@Data
public class NightRule {
    /**
     * 夜间时间段 - 开始
     */
    private Date start;

    /**
     * 夜间时间段 - 结束
     */
    private Date end;

    /**
     * 超公里加收单价（元/公里）
     */
    private BigDecimal perKiloPrice;

    /**
     * 超时间加收单价（元/分钟）
     */
    private BigDecimal perMinutePrice;
}
