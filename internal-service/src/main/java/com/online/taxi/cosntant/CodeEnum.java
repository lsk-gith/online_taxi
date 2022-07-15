package com.online.taxi.cosntant;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 18:15
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
public interface CodeEnum {
    /**
     * 返回枚举体的code值
     *
     * @return code值
     */
    public abstract int getCode();

    /**
     * 返回枚举体的code值
     *
     * @return 字符串格式的code值
     */
    default String getCodeAsString(){
        return "" + getCode();
    }
}
