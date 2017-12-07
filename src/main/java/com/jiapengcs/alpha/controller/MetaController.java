package com.jiapengcs.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.model.Meta;
import com.jiapengcs.alpha.service.MetaService;
import com.jiapengcs.alpha.service.RelationService;
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

    @Autowired
    private RelationService relationService;

    @PostMapping("/meta")
    public Meta save(@RequestBody Meta meta, HttpServletRequest request) {
        return metaService.saveMeta(meta);
    }

    @DeleteMapping("/meta/{mid}")
    public void delete(@PathVariable Long mid, HttpServletRequest request) {
        metaService.deleteMeta(mid);
    }

    @PutMapping("/meta/{mid}")
    public Meta update(@PathVariable Long mid, @RequestBody JSONObject params, HttpServletRequest request) {
        return metaService.updateMeta(mid, params);
    }

    @GetMapping("/meta/{mid}")
    public Meta get(@PathVariable Long mid, HttpServletRequest request) {
        return metaService.getMeta(mid);
    }

    @GetMapping("/meta/type/{metaType}")
    public List<Meta> listByType(@PathVariable String metaType, HttpServletRequest request) {
        return metaService.listMetasByType(metaType);
    }

    @GetMapping("/content/{cid}/meta")
    public List<Meta> listByContent(@PathVariable Long cid, HttpServletRequest request) {
        List<Long> mids = relationService.listMidsByCid(cid);
        return metaService.listMetasByMids(mids);
    }
}
