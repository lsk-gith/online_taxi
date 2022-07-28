package com.online.taxi.dto.valuation.charging;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 21:19
 * @Description: com.online.taxi.dto.valuation 远途服务费
 * @version: 1.0
 */
@Data
public class BeyondRule {
    /**
     * 远途起算公里（公里）
     */
    private BigDecimal startKilo;

    /**
     * 远途单价（元/公里）
     */
    private BigDecimal perKiloPrice;
}
