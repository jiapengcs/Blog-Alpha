package com.jiapengcs.alpha.repository;

import com.jiapengcs.alpha.model.Attachment;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface AttachmentRepository extends BaseRepository<Attachment, Long> {

    @Query(value = "select fileSize from Attachment a")
    List<Long> findAllFileSizes();
}
