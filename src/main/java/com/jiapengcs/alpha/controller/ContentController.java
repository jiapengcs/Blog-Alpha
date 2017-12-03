package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@RestController
@RequestMapping("/content")
@ResponseResultWrapper
public class ContentController {

    @RequestMapping("/test")
    public String test() {
        return "nice to meet you";
    }

    @RequestMapping("/get")
    public void get() {

    }
}
