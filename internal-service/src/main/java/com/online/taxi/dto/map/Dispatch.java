package com.online.taxi.dto.map;

import com.online.taxi.map.Vehicle;
import lombok.Data;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 22:42
 * @Description: com.online.taxi.dto.map
 * @version: 1.0
 */
@Data
public class Dispatch {
    private Integer count;

    private String orderId;

    private List<Vehicle> vehicles;
}
