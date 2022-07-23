package com.online.taxi.map;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 16:31
 * @Description: com.online.taxi.map
 * @version: 1.0
 */
@Data
public class Route {
    /**
     * 行驶距离（米）
     */
    private Double distance;

    /**
     * 行驶时间（秒）
     */
    private Double duration;
}
