package com.online.taxi.config;

import java.lang.annotation.*;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 17:54
 * @Description: com.online.taxi.config
 * @version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Documented
public @interface Cache {
}
