package com.jiapengcs.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Content;
import com.jiapengcs.alpha.service.ContentService;
import com.jiapengcs.alpha.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class ContentController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private RelationService relationService;

    @PostMapping("/content")
    public Content save(@RequestBody Content content, HttpServletRequest request) {
        return contentService.saveContent(content);
    }

    @DeleteMapping("/content/{cid}")
    public void delete(@PathVariable Long cid, HttpServletRequest request) {
        contentService.deleteContent(cid);
    }

    @PutMapping("/content/{cid}")
    public Content update(@PathVariable Long cid, @RequestBody JSONObject params, HttpServletRequest request) {
        return contentService.updateContent(cid, params);
    }

    @GetMapping("/content/{cid}")
    public Content get(@PathVariable Long cid, HttpServletRequest request) {
        contentService.increaseHits(cid);
        return contentService.getContent(cid);
    }

    @GetMapping("/content")
    public List<Content> list(HttpServletRequest request) {
        return contentService.listAllContents();
    }

    @GetMapping("/content/page")
    public Page<Content> page(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                              HttpServletRequest request) {
        PageRequest pageRequest = new PageRequest(page, size);
        return contentService.listAllContentsByPage(pageRequest);
    }

    @GetMapping("/meta/{mid}/content")
    public List<Content> pageByMeta(@PathVariable Long mid, HttpServletRequest request) {
        List<Long> cids = relationService.listCidsByMid(mid);
        return contentService.listContentsByCids(cids);
    }

    @GetMapping("/meta/{mid}/content/page")
    public Page<Content> pageByMeta(@PathVariable Long mid, @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size, HttpServletRequest request) {
        List<Long> cids = relationService.listCidsByMid(mid);
        PageRequest pageRequest = new PageRequest(page, size);
        return contentService.listContentsByCidsByPage(cids, pageRequest);
    }
}
