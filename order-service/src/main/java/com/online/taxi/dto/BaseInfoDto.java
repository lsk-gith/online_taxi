package com.online.taxi.dto;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 22:51
 * @Description: com.online.taxi.dto
 * @version: 1.0
 */
@Data
public class BaseInfoDto {
    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 渠道名称
     */
    private String channelName;

    /**
     * 服务名称
     */
    private String serviceTypeName;

    /**
     * 车辆级别名称
     */
    private String carLevelName;
}
