package com.lsk.apidemo;

import java.io.Serializable;

/**
 * @Auther: lsk
 * @Date: 2022/4/10 - 04 - 10 - 14:27
 * @Description: com.lsk.apidemo
 * @version: 1.0
 */
public class ApiBean implements Serializable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
