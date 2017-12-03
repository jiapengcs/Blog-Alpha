package com.jiapengcs.alpha.controller.wrapper;

import java.lang.annotation.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResultWrapper {
}
