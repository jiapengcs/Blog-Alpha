package com.jiapengcs.alpha.controller.handler;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.AuthException;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.exception.ParameterException;
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

    @ExceptionHandler(AuthException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseResult handleAuthException(AuthException e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.UNAUTHORIZED.getMessage();
        return new ResponseResult(ResponseCode.UNAUTHORIZED.getStatus(), message, request.getRequestURI());
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseResult handleDataAccessException(DataAccessException e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.DATA_ACCESS_ERROR.getMessage();
        return new ResponseResult(ResponseCode.DATA_ACCESS_ERROR.getStatus(), message, request.getRequestURI());
    }

    @ExceptionHandler(ParameterException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseResult handleParameterException(ParameterException e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.PARAMETER_ERROR.getMessage();
        return new ResponseResult(ResponseCode.PARAMETER_ERROR.getStatus(), message, request.getRequestURI());
    }

    @ExceptionHandler(PermissionException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseResult handlePermissionException(PermissionException e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.FORBIDDEN.getMessage();
        return new ResponseResult(ResponseCode.FORBIDDEN.getStatus(), message, request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult handleException(Exception e, HttpServletRequest request) {
        String message = e.getMessage() != null ? e.getMessage() : ResponseCode.ERROR.getMessage();
        return new ResponseResult(ResponseCode.ERROR.getStatus(), message, request.getRequestURI());
    }
}
