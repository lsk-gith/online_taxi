package com.online.taxi.dto;

import com.online.taxi.entity.DriverBaseInfo;
import com.online.taxi.entity.DriverInfo;
import com.online.taxi.entity.DriverLicenceInfo;
import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 16:59
 * @Description: com.online.taxi.dto
 * @version: 1.0
 */
@Data
public class DriverBaseInfoView {
    private DriverBaseInfo driverBaseInfo;

    private DriverInfo driverInfo;

    private DriverLicenceInfo driverLicenceInfo;
}
