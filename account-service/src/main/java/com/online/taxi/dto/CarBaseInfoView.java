package com.online.taxi.dto;

import com.online.taxi.entity.CarBaseInfo;
import com.online.taxi.entity.CarInfo;
import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 17:53
 * @Description: com.online.taxi.accountservice.dto
 * @version: 1.0
 */
@Data
public class CarBaseInfoView {
    private CarBaseInfo carBaseInfo;

    private CarInfo carInfo;
}
