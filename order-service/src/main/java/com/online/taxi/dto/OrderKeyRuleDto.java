package com.online.taxi.dto;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/30 - 07 - 30 - 16:31
 * @Description: com.online.taxi.dto
 * @version: 1.0
 */
@Data
public class OrderKeyRuleDto {
    private Integer orderId;
    private Integer cityCode;
    private Integer serviceTypeId;
    private Integer channelId;
    private Integer carTypeId;
}
