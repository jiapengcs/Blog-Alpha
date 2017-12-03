package com.jiapengcs.alpha.aspect.email;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@Aspect
@Component
public class EmailAspect {

    public static final Logger LOGGER = LoggerFactory.getLogger(EmailAspect.class);

    @AfterReturning("execution(* com.jiapengcs.alpha.service.CommentService.saveComment(..)) && @annotation(EnableEmail)")
    public void sendEmail() {
        LOGGER.info("Sending email...");
    }
}
