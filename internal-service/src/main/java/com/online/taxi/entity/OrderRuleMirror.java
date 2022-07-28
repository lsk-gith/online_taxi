package com.online.taxi.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/26 - 07 - 26 - 21:10
 * @Description: com.online.taxi.entity
 * @version: 1.0
 */
@Data
public class OrderRuleMirror {
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_order_rule_mirror.order_id
     *
     * @mbggenerated
     */
    private Integer orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_order_rule_mirror.rule_id
     *
     * @mbggenerated
     */
    private Integer ruleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_order_rule_mirror.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_order_rule_mirror.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tbl_order_rule_mirror.rule
     *
     * @mbggenerated
     */
    private String rule;
}
