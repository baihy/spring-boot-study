package com.baihy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @projectName: springboot
 * @packageName: com.baihy.annotation
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-18 19:12
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    String value() default "baihy";

}
