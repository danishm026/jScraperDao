package com.arc.jScraperDao.dto.db;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 19/11/16.
 */
public class ModelPageDetailsTest {
    private static final String NAME = "testName";
    private static final int PAGE_NUMBER = 3;
    private static final int STARTING_IMAGE_NUMBER = 34;
    private static final int LAST_IMAGE_NUMBER = 58;

    @Test
    public void testGetAndSetName() {
        ModelPageDetails modelPageDetails = new ModelPageDetails();
        modelPageDetails.setName(NAME);
        assertEquals(NAME, modelPageDetails.getName());
    }

    @Test
    public void testGetAndSetPageNumber() {
        ModelPageDetails modelPageDetails = new ModelPageDetails();
        modelPageDetails.setPageNumber(PAGE_NUMBER);
        assertEquals(PAGE_NUMBER, modelPageDetails.getPageNumber());
    }

    @Test
    public void testGetAndSetStartingImageNumber() {
        ModelPageDetails modelPageDetails = new ModelPageDetails();
        modelPageDetails.setStartingImageNumber(STARTING_IMAGE_NUMBER);
        assertEquals(STARTING_IMAGE_NUMBER, modelPageDetails.getStartingImageNumber());
    }

    @Test
    public void testGetAndSetSetLastImageNumber() {
        ModelPageDetails modelPageDetails = new ModelPageDetails();
        modelPageDetails.setLastImageNumber(LAST_IMAGE_NUMBER);
        assertEquals(LAST_IMAGE_NUMBER, modelPageDetails.getLastImageNumber());
    }
}
