package com.online.taxi.dto;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/25 - 07 - 25 - 22:42
 * @Description: com.online.taxi.dto
 * @version: 1.0
 */
@Data
public class OrderPrice {
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 订单价格
     */
    private Double price;
}
