package com.online.taxi.cosntant;

import lombok.Data;
import lombok.Getter;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 18:14
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
@Getter
public enum BusinessInterfaceStatus implements CodeEnum{
    /**
     * 操作成功
     */
    SUCCESS(0, "success"),
    /**
     * 操作失败
     */
    FAIL(1, "fail");

    private final int code;
    private final String value;

    BusinessInterfaceStatus(int code, String value){
        this.code = code;
        this.value = value;
    }
}
