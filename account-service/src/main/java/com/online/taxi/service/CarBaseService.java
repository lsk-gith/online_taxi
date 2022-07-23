package com.online.taxi.service;

import com.online.taxi.dto.CarBaseInfoView;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.CarBaseInfo;

/**
 * @Auther: lsk
 * @Date: 2022/7/20 - 07 - 20 - 22:12
 * @Description: com.online.taxi.service
 * @version: 1.0
 */
public interface CarBaseService {
    int updateCarBaseInfoView(CarBaseInfo view);

    ResponseResult addCarBaseInfo(CarBaseInfoView view);
}
