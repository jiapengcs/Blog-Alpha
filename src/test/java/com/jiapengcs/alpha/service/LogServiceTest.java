package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.BlogAlphaApplicationTests;
import com.jiapengcs.alpha.model.Log;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-6
 */
public class LogServiceTest extends BlogAlphaApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceTest.class);

    @Autowired
    private LogService logService;

    @Test
    public void listAllLogsByPageTest() {
        Sort sort = new Sort(Sort.Direction.DESC, "logTime");
        PageRequest pageRequest = new PageRequest(1, 5, sort);
        Page<Log> page = logService.listAllLogsByPage(pageRequest);
        Assert.assertTrue(page != null);
        LOGGER.info(String.valueOf(page.getContent()));
    }
}
