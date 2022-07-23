package com.online.taxi.dto.push;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 17:09
 * @Description: com.online.taxi.dto.push
 * @version: 1.0
 */
public class PushLoopBatchRequest {
    private Integer acceptIdentity;

    private List<String> acceptIds;

    private Integer messageType;

    private String messageBody;

    private String sendId;

    private Integer sendIdentity;

    public PushLoopBatchRequest(Integer acceptIdentity, List<String> acceptIds, Integer messageType, String messageBody, String sendId, Integer sendIdentity) {
        this.acceptIdentity = acceptIdentity;
        this.acceptIds = acceptIds;
        this.messageType = messageType;
        this.messageBody = messageBody;
        this.sendId = sendId;
        this.sendIdentity = sendIdentity;
    }

    public PushLoopBatchRequest() {
    }
}
