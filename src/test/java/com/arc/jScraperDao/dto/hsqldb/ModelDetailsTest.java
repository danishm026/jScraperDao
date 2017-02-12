package com.arc.jScraperDao.dto.hsqldb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 19/11/16.
 */
public class ModelDetailsTest {
    private static final String NAME = "testName";
    private static final String BASE_URL = "testBaseUrl";
    private static final int NUMBER_OF_PAGES = 5;
    private static final int NUMBER_OF_IMAGES = 268;

    @Test
    public void testGetAndSetName() {
        ModelDetails modelDetails = new ModelDetails();
        modelDetails.setName(NAME);
        assertEquals(NAME, modelDetails.getName());
    }

    @Test
    public void testGetAndSetBaseUrl() {
        ModelDetails modelDetails = new ModelDetails();
        modelDetails.setBaseUrl(BASE_URL);
        assertEquals(BASE_URL, modelDetails.getBaseUrl());
    }

    @Test
    public void testGetAndSetNumberOfPages() {
        ModelDetails modelDetails = new ModelDetails();
        modelDetails.setNumberOfPages(NUMBER_OF_PAGES);
        assertEquals(NUMBER_OF_PAGES, modelDetails.getNumberOfPages());
    }

    @Test
    public void testGetAndSetNumberOfImages() {
        ModelDetails modelDetails= new ModelDetails();
        modelDetails.setNumberOfImages(NUMBER_OF_IMAGES);
        assertEquals(NUMBER_OF_IMAGES, modelDetails.getNumberOfImages());
    }
}
