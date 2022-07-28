package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 服务类型表
 */
@Data
public class ServiceType implements Serializable {
    private Integer id;

    /**
     * 服务类型名称
     */
    private String serviceTypeName;

    /**
     * 服务类型状态 1开启 0暂停
     */
    private Integer serviceTypeStatus;

    /**
     * 使用状态  1使用 0未使用
     */
    private String isUse;

    /**
     * 操作人id
     */
    private Integer operatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}