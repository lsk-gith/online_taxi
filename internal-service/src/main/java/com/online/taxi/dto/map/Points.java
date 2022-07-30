package com.online.taxi.dto.map;

import lombok.Data;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/30 - 07 - 30 - 15:41
 * @Description: com.online.taxi.dto.map
 * @version: 1.0
 */
@Data
public class Points {
    private Location startPoint;

    private Location endPoint;

    private List<Location> points;

    private Integer pointCount ;
}
