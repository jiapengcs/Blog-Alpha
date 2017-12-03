package com.jiapengcs.alpha.aspect.email;

import java.lang.annotation.*;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface EnableEmail {
}
