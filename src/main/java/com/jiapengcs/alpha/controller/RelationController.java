package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.model.Relation;
import com.jiapengcs.alpha.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-7
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class RelationController {

    @Autowired
    private RelationService relationService;

    @PostMapping("/relation")
    public Relation save(@RequestBody Relation relation, HttpServletRequest request) {
        return relationService.saveRelation(relation);
    }

    @DeleteMapping("/relation/{rid}")
    public void delete(@PathVariable Long rid, HttpServletRequest request) {
        relationService.deleteRelation(rid);
    }
}
