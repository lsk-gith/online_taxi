package com.online.taxi.dto.valuation.charging;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 21:16
 * @Description: com.online.taxi.dto.valuation计费规则主键类
 * @version: 1.0
 */
@Data
public class KeyRule {
    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 服务类型id
     */
    private Integer serviceTypeId;

    /**
     * 服务类型名称
     */
    private String serviceTypeName;

    /**
     * 渠道名称id
     */
    private Integer channelId;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 车辆级别id
     */
    private Integer carLevelId;

    /**
     * 车辆级别名称
     */
    private String carLevelName;
}
