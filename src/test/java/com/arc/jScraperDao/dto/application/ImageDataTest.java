package com.arc.jScraperDao.dto.application;

import com.arc.jScraperDao.dto.application.ImageData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 4/11/16.
 */
public class ImageDataTest {
    private static final String THUMBNAIL_URL = "testThumbnailUrl";
    private static final String IMAGE_URL = "testImageUrl";

    @Test
    public void getAndSetThumbnailUrlTest() {
        ImageData imageData = new ImageData();
        imageData.setThumbnailUrl(THUMBNAIL_URL);
        assertEquals(THUMBNAIL_URL, imageData.getThumbnailUrl());
    }

    @Test
    public void getAndSetImageUrlTest() {
        ImageData imageData = new ImageData();
        imageData.setImageUrl(IMAGE_URL);
        assertEquals(IMAGE_URL, imageData.getImageUrl());
    }
}
