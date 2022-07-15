package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/19 - 07 - 19 - 22:33
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class UpdateDriverStatusRequest {

    private Integer id;

    private Integer useStatus;

    private Integer signStatus;

    private Integer carId;

}
