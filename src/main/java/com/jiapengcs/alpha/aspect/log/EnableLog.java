package com.jiapengcs.alpha.aspect.log;

import java.lang.annotation.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface EnableLog {
}
