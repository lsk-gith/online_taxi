package com.online.taxi.request;

import com.online.taxi.dto.CarBaseInfoView;
import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/20 - 07 - 20 - 22:17
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class CarChangeRequest {
    private CarBaseInfoView data;
}
