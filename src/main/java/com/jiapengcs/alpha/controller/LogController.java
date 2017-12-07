package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.model.Log;
import com.jiapengcs.alpha.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/log/page")
    public Page<Log> page(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                              HttpServletRequest request) {
        PageRequest pageRequest = new PageRequest(page, size);
        return logService.listAllLogsByPage(pageRequest);
    }
}
