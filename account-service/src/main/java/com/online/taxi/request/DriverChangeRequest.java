package com.online.taxi.request;

import com.online.taxi.dto.DriverBaseInfoView;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/19 - 07 - 19 - 21:45
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class DriverChangeRequest {
    private DriverBaseInfoView data;

    private int id;

    private int driverStatus;

    private int carId;

    private Date searchCreateStartTime;

    private Date searchCreateEndTime;

    private String address;
}
