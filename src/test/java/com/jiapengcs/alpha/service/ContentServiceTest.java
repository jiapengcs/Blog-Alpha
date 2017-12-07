package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.BlogAlphaApplicationTests;
import com.jiapengcs.alpha.model.Content;
import com.jiapengcs.alpha.service.impl.ContentServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-6
 */
public class ContentServiceTest extends BlogAlphaApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentServiceTest.class);

    @Autowired
    private ContentService contentService;

    @Test
    public void increaseHitsTest() {
        contentService.increaseHits(4L);
    }

    @Test
    public void listContentsByCidsByPageTest() {
        List<Long> cids = Arrays.asList(1L, 4L);
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<Content> page = contentService.listContentsByCidsByPage(cids, pageRequest);
        LOGGER.info(String.valueOf(page));
        LOGGER.info(String.valueOf(page.getContent()));
    }
}
