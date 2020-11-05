package com.xnj;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author chen xuanyi
 * @Date 2020/4/30 12:05
 */
@Target({ElementType.TYPE,ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)

public @interface xnj {
    String value() default "自己所写";
}
