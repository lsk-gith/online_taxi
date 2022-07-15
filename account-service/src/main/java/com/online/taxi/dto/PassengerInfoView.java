package com.online.taxi.dto;

import com.online.taxi.entity.PassengerAddress;
import com.online.taxi.entity.PassengerInfo;
import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 12:14
 * @Description: com.online.taxi.dto
 * @version: 1.0
 */
@Data
public class PassengerInfoView {
    private PassengerInfo passengerInfo;

    private PassengerAddress passengerAddress;
}
