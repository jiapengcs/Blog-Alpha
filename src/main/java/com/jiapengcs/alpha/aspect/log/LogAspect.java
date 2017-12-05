package com.jiapengcs.alpha.aspect.log;

import com.jiapengcs.alpha.model.Log;
import com.jiapengcs.alpha.repository.LogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-11-30
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private LogRepository logRepository;

    /**
     * match classes or methods in service layer and annotated by the given annotation
     */
    @Pointcut("within(com.jiapengcs.alpha.service..*) && (@within(EnableLog) || @annotation(EnableLog))")
    private void serviceAspect() {
    }

    /**
     * match classes or methods in controller layer and annotated by the given annotation
     */
    @Pointcut("within(com.jiapengcs.alpha.controller..*) && (@within(EnableLog) || @annotation(EnableLog)) && args(.., request)")
    private void controllerAspect(HttpServletRequest request) {
    }

    @Around("serviceAspect()")
    public Object proceedService(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        String method = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();
        long begin = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("service-info{method:\"{}\", args:\"{}\", cost:\"{}ms\"}",
                    method, Arrays.toString(args), end - begin);
        } catch (Throwable throwable) {
            String exception = throwable.getClass().getName();
            String message = throwable.getMessage();
            long end = System.currentTimeMillis();
            LOGGER.error("service-error{exception:\"{}\", message:\"{}\", method:\"{}\", args:\"{}\", cost:\"{}ms\"}",
                    exception, message, method, Arrays.toString(args), end - begin);
            throw throwable;
        }
        return result;
    }

    @Around(value = "controllerAspect(request)", argNames = "joinPoint,request")
    public Object proceedController(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {
        Object result = null;
        String uri = request.getRequestURI();
        String method = joinPoint.getSignature().toString();
        Object[] pointArgs = joinPoint.getArgs();
        Object[] args = Arrays.copyOfRange(pointArgs, 0, pointArgs.length - 1);
        String ip = request.getRemoteAddr();
        long begin = System.currentTimeMillis();
        try {
            result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("controller-info{uri:\"{}\", method:\"{}\", args:\"{}\", ip:\"{}\", cost:\"{}ms\"}",
                    uri, method, Arrays.toString(args), ip, end - begin);
        } catch (Throwable throwable) {
            String exception = throwable.getClass().getName();
            String message = throwable.getMessage();
            long end = System.currentTimeMillis();
            Log log = new Log(uri, method, Arrays.toString(args), ip, exception, message, end - begin, new Timestamp(end));
            logRepository.save(log);
            LOGGER.error("controller-error{exception:\"{}\", message:\"{}\", uri:\"{}\", method:\"{}\", args:\"{}\", ip:\"{}\", cost:\"{}ms\"}",
                    exception, message, uri, method, Arrays.toString(args), ip, end - begin);
            throw throwable;
        }
        return result;
    }

    @Before(value = "execution(* com.jiapengcs.alpha.controller.handler.GlobalExceptionHandler.proceedException(..)) && args(e, request)", argNames = "e,request")
    public void proceedExceptionHandler(Exception e, HttpServletRequest request) {
        Object result = null;
        String uri = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String exception = e.getClass().getName();
        String message = e.getMessage();
        Log log = new Log(uri, "framework", null, ip, exception, message, 0L, new Timestamp(System.currentTimeMillis()));
        logRepository.save(log);
        LOGGER.error("controller-error{exception:\"{}\", message:\"{}\", uri:\"{}\", method:\"{}\", args:\"{}\", ip:\"{}\", cost:\"{}ms\"}",
                exception, message, uri, "framework", null, ip, 0);
        e.printStackTrace();
    }
}
