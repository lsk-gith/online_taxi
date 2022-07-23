package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/20 - 07 - 20 - 22:19
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class UpdateCarRequest {
    private Integer id;

    private Integer useStatus;

    private Integer totalMile;
}
