package com.arc.jScraperDao.dto.hsqldb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 20/11/16.
 */
public class ImageDetailsTest {
    private static final String NAME = "testName";
    private static final int PAGE_NUMBER_ = 5;
    private static final String THUMBNAIL_URL = "testThumbnailUrl";
    private static final String IMAGE_URL = "testImageUrl";

    @Test
    public void testGetAndSetName() {
        ImageDetails imageDetails = new ImageDetails();
        imageDetails.setName(NAME);
        assertEquals(NAME, imageDetails.getName());
    }

    @Test
    public void testGetAndSetPageNumber() {
        ImageDetails imageDetails = new ImageDetails();
        imageDetails.setPageNumber(PAGE_NUMBER_);
        assertEquals(PAGE_NUMBER_, imageDetails.getPageNumber());
    }

    @Test
    public void getAndSetThumbnailUrlTest() {
        ImageDetails imageDetails = new ImageDetails();
        imageDetails.setThumbnailUrl(THUMBNAIL_URL);
        assertEquals(THUMBNAIL_URL, imageDetails.getThumbnailUrl());
    }

    @Test
    public void getAndSetImageUrlTest() {
        ImageDetails imageDetails = new ImageDetails();
        imageDetails.setImageUrl(IMAGE_URL);
        assertEquals(IMAGE_URL, imageDetails.getImageUrl());
    }
}
