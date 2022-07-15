package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 12:27
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class PassengerInfoExtRequest {
    private Integer id;

    private Integer isContact;

    private Integer isShare;

    private String sharingTime;
}
