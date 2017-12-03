package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.model.Log;
import com.jiapengcs.alpha.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@RestController
@RequestMapping("/admin/log")
@EnableLog
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/page")
    private Page<Log> page() {
        PageRequest request = new PageRequest(0, 10);
        return logService.listAllContentsByPage(request);
    }
}
