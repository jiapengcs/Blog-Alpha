package com.jiapengcs.alpha.controller.handler;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseCode;
import com.jiapengcs.alpha.controller.wrapper.ResponseResult;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * override default error controller, return custom formatted json
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@RestController
@EnableLog
public class ErrorHandleController implements ErrorController {
    
    @Override
    public String getErrorPath() {
        return "";
    }

    @RequestMapping("/error")
    public ResponseResult handleError(HttpServletRequest request) {
        return new ResponseResult(ResponseCode.NOT_FOUND.getStatus(), ResponseCode.NOT_FOUND.getMessage(), request.getRequestURI());
    }

    @RequestMapping("/error/block")
    public ResponseResult handleBlock(HttpServletRequest request) {
        return new ResponseResult(ResponseCode.ERROR.getStatus(), "You are blocked, bro!",request.getRequestURI());
    }
}
