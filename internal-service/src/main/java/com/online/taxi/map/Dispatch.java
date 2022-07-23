package com.online.taxi.map;

import lombok.Data;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 16:05
 * @Description: com.online.taxi.map
 * @version: 1.0
 */
@Data
public class Dispatch {

    private Integer count;

    private String orderId;

    private List<Vehicle> vehicles;
}
