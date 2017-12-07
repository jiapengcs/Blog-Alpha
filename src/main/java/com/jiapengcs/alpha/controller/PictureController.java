package com.jiapengcs.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.model.Picture;
import com.jiapengcs.alpha.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/7
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @PostMapping("/picture")
    public Picture save(Picture picture, HttpServletRequest request) {
        //TODO: record file path
        return pictureService.savePicture(picture);
    }

    @DeleteMapping("/picture/{pid}")
    public void delete(@PathVariable Long pid, HttpServletRequest request) {
        pictureService.deletePicture(pid);
    }

    @PutMapping("/picture/{pid}")
    public Picture update(@PathVariable Long pid, @RequestBody JSONObject params, HttpServletRequest request) {
        return pictureService.updatePicture(pid, params);
    }

    @GetMapping("/picture/{pid}")
    public Picture get(@PathVariable Long pid, HttpServletRequest request) {
        return pictureService.getPicture(pid);
    }

    @GetMapping("/picture")
    public List<Picture> list(HttpServletRequest request) {
        return pictureService.listAllPictures();
    }

    @GetMapping("/picture/page")
    public Page<Picture> page(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size,
                              HttpServletRequest request) {
        PageRequest pageRequest = new PageRequest(page, size);
        return pictureService.listAllPicturesByPage(pageRequest);
    }
}
