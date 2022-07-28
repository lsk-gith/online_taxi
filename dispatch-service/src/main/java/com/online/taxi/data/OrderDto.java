package com.online.taxi.data;

import com.online.taxi.entity.Order;

/**
 * @Auther: lsk
 * @Date: 2022/7/24 - 07 - 24 - 11:25
 * @Description: com.online.taxi.data
 * @version: 1.0
 */
public class OrderDto extends Order {
    private Integer orderId;

    private Integer updateType;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }



    public Integer getUpdateType() {
        return updateType;
    }

    public void setUpdateType(Integer updateType) {
        this.updateType = updateType;
    }

}
