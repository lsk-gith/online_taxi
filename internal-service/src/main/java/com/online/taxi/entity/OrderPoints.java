package com.online.taxi.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class OrderPoints implements Serializable {
    private Integer id;

    /**
     * 司机Id
     */
    private Integer driverId;

    /**
     * 车辆Id
     */
    private Integer carId;

    /**
     * 订单id
     */
    private Integer orderId;

    private String points;

    private static final long serialVersionUID = 1L;
}