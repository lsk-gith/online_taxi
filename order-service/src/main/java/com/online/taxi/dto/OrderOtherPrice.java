package com.online.taxi.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: lsk
 * @Date: 2022/7/25 - 07 - 25 - 22:45
 * @Description: com.online.taxi.dto
 * @version: 1.0
 */
@Data
public class OrderOtherPrice {
    private Integer orderId;
    private Integer passengerId;
    private BigDecimal totalPrice;
}
