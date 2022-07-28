package com.online.taxi.dto.valuation.charging;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: lsk
 * @Date: 2022/7/26 - 07 - 26 - 21:48
 * @Description: com.online.taxi.dto.valuation
 * @version: 1.0
 */
@Data
public class TagPrice {
    /**
     * 标签名称
     */
    private String name;

    /**
     * 标签费用
     */
    private BigDecimal price;
}
