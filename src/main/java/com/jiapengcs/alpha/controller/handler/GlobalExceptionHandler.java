package com.jiapengcs.alpha.controller.handler;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.util.constant.ResponseCode;
import com.jiapengcs.alpha.controller.wrapper.ResponseResult;
import com.jiapengcs.alpha.exception.PermissionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * handle global exceptions thrown by all controllers
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseResult proceedPermissionException(PermissionException e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.FORBIDDEN.getMessage();
        return new ResponseResult(ResponseCode.FORBIDDEN.getStatus(), message, request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult proceedException(Exception e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.ERROR.getMessage();
        return new ResponseResult(ResponseCode.ERROR.getStatus(), message, request.getRequestURI());
    }
}
