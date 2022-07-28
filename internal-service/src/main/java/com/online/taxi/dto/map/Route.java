package com.online.taxi.dto.map;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/26 - 07 - 26 - 22:02
 * @Description: com.online.taxi.dto.map
 * @version: 1.0
 */
@Data
public class Route {
    /**
     * 距离测量结果
     *
     */
    /**
     * 行驶距离（米）
     */
    private Double distance;

    /**
     * 行驶时间（秒）
     */
    private Double duration;
}
