package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.BlogAlphaApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/7
 */
public class AttachmentServiceTest extends BlogAlphaApplicationTests {

    public static final Logger LOGGER = LoggerFactory.getLogger(AttachmentServiceTest.class);

    @Autowired
    private AttachmentService attachmentService;

    @Test
    public void getFilesTotalSizeTest() {
        Long totalSize = attachmentService.getFilesTotalSize();
        Assert.assertTrue(totalSize != null);
        LOGGER.info("Total size: {}", totalSize);
    }

    @Test
    public void getFilesNumberTest() {
        Long number = attachmentService.getFilesNumber();
        Assert.assertTrue(number != null);
        LOGGER.info("Files number: {}", number);
    }
}
