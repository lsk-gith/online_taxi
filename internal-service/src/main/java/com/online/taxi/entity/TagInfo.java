package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class TagInfo implements Serializable {
    private Integer id;

    /**
     * tag名字
     */
    private String tagName;

    /**
     * tag照片
     */
    private String tagImg;

    /**
     * 是否显示（0：不显示，1：显示）
     */
    private Byte status;

    /**
     * 创建人
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