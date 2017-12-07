package com.jiapengcs.alpha.service;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.model.Picture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-4
 */
public interface PictureService {

    Picture savePicture(Picture picture);

    void deletePicture(Long pid);

    Picture updatePicture(Long pid, JSONObject params);

    Picture getPicture(Long pid);

    List<Picture> listAllPictures();

    Page<Picture> listAllPicturesByPage(Pageable pageable);
}
