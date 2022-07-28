package com.online.taxi.cosntant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 22:07
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum AmapOrderEnum {
    NO_ASSIGN(1,"未派单"),
    /**
     *已派单
     */
    ASSIGN(2,"已派单"),
    /**
     *开始计费
     */
    CHARGE_START(3,"开始计费"),
    /**
     *订单撤销
     */
    CANCEL_ORDER(4,"订单撤销"),
    /**
     *订单待支付
     */
    TO_PAY(5,"订单待支付"),
    /**
     *订单已评价
     */
    EVALUATE_DO(6,"订单已评价"),
    /**
     *订单待评价
     */
    TO_EVALUATE(7,"订单待评价"),
    /**
     *结束行程
     */
    END_TRAVEL(8,"结束行程"),
    /**
     *开始服务
     */
    START_SERVICE(9,"开始服务"),
    /**
     *撤单待支付
     */
    CANCEL_ORDER_TO_PAY(10,"撤单待支付"),

    EC9999(9999, "其他异常");

    private int code;
    private String value;
}
