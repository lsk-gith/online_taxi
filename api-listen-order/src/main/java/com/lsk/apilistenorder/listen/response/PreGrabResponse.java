package com.lsk.apilistenorder.listen.response;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 22:09
 * @Description: com.lsk.apilistenorder.listen.response
 * @version: 1.0
 */
@Data
public class PreGrabResponse {
    private int orderId;
    private String startAddress;
    private String endAddress;
}
