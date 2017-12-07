package com.jiapengcs.alpha.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Picture;
import com.jiapengcs.alpha.repository.PictureRepository;
import com.jiapengcs.alpha.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/7
 */
@Service
@EnableLog
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository repository;

    @Override
    public Picture savePicture(Picture picture) {
        picture.setUploadTime(new Timestamp(System.currentTimeMillis()));
        return repository.save(picture);
    }

    @Override
    public void deletePicture(Long pid) {
        if (!repository.exists(pid)) {
            throw new DataAccessException("Picture does not exist!");
        }
        repository.delete(pid);
    }

    @Override
    public Picture updatePicture(Long pid, JSONObject params) {
        Picture picture = repository.findOne(pid);
        if (picture == null) {
            throw new DataAccessException("Picture does not exist!");
        }
        picture.setSubject(params.getString("subject") != null ? params.getString("subject") : picture.getSubject());
        picture.setLocation(params.getString("location") != null ? params.getString("location") : picture.getLocation());
        picture.setDescription(params.getString("description") != null ? params.getString("description") : picture.getDescription());
        picture.setFilmTime(params.getLong("filmTime") != null ? new Timestamp(params.getLong("filmTime")) : picture.getFilmTime());
        return repository.save(picture);
    }

    @Override
    public Picture getPicture(Long pid) {
        return null;
    }

    @Override
    public List<Picture> listAllPictures() {
        return null;
    }

    @Override
    public Page<Picture> listAllPicturesByPage(Pageable pageable) {
        return null;
    }
}
