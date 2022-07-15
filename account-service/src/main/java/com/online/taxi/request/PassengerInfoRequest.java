package com.online.taxi.request;

import com.online.taxi.dto.PassengerInfoView;
import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 12:13
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class PassengerInfoRequest {
    private Integer id;

    private PassengerInfoView data;
}
