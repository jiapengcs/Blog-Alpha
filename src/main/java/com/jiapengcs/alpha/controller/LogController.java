package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.model.Log;
import com.jiapengcs.alpha.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@RestController
@RequestMapping("/admin/log")
@EnableLog
@ResponseResultWrapper
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/page")
    public Page<Log> page(HttpServletRequest request) {
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<Log> page = logService.listAllLogsByPage(pageRequest);
        return page;
    }
}
