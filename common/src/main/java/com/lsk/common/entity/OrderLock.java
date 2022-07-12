package com.lsk.common.entity;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 22:52
 * @Description: com.lsk.common.entity
 * @version: 1.0
 */
@Data
public class OrderLock {
    private Integer orderId;
    private Integer driverId;
}
