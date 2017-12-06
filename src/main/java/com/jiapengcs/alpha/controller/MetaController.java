package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.model.Meta;
import com.jiapengcs.alpha.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/6
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class MetaController {

    @Autowired
    private MetaService metaService;

    @PostMapping("/meta")
    public Meta save(@RequestBody Meta meta, HttpServletRequest request) {
        return metaService.saveMeta(meta);
    }

    @DeleteMapping("/meta/{mid}")
    public void delete(@PathVariable Long mid, HttpServletRequest request) {
        metaService.deleteMeta(mid);
    }

    @PutMapping("/meta/{mid}")
    public Meta update() {
        return null;
    }

    @GetMapping("/meta/{mid}")
    public Meta get(@PathVariable Long mid, HttpServletRequest request) {
        return metaService.getMeta(mid);
    }

    @GetMapping("/meta")
    public List<Meta> list() {
        return metaService.listAllMetas();
    }
}
