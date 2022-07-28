package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 车辆级别列表
 */
@Data
public class CarLevel implements Serializable {
    private Integer id;

    /**
     * 车辆级别标签
     */
    private String label;

    /**
     * 车型图标
     */
    private String icon;

    private Date createTime;

    private Date updateTime;

    /**
     * 操作人ID
     */
    private Integer operatorId;

    /**
     * 状态:0未启用1启用
     */
    private Byte enable;

    private static final long serialVersionUID = 1L;
}