package com.lsk.common.dto.order;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/10 - 07 - 10 - 15:39
 * @Description: com.lsk.common.dto.order
 * @version: 1.0
 */
@Data
public class BaseOrder {
    String startLatitude;

    String startLongitude;

    String endLatitude;

    String endLongitude;
}
