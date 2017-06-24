package com.arc.jScraperDao.dto.application;

import com.arc.jScraperDao.dto.application.ImageData;
import com.arc.jScraperDao.dto.application.ModelPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 4/11/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ModelPageTest {
    @Mock
    private static List<ImageData> imageDataList;
    private static final int PAGE_NUMBER = 3;
    private static final int STARTING_IMAGE_NUMBER = 34;
    private static final int LAST_IMAGE_NUMBER = 58;

    @Test
    public void getAndSetPageNumberTest() {
        ModelPage modelPage = new ModelPage();
        modelPage.setPageNumber(PAGE_NUMBER);
        assertEquals(PAGE_NUMBER, modelPage.getPageNumber());
    }

    @Test
    public void getAndSetStartingImageTest() {
        ModelPage modelPage = new ModelPage();
        modelPage.setStartingImageNumber(STARTING_IMAGE_NUMBER);
        assertEquals(STARTING_IMAGE_NUMBER, modelPage.getStartingImageNumber());
    }

    @Test
    public void getAndSetLastImageNumberTest() {
        ModelPage modelPage = new ModelPage();
        modelPage.setLastImageNumber(LAST_IMAGE_NUMBER);
        assertEquals(LAST_IMAGE_NUMBER, modelPage.getLastImageNumber());
    }

    @Test
    public void getAndSetImageDataListTest() {
        ModelPage modelPage = new ModelPage();
        modelPage.setImageDataList(imageDataList);
        assertEquals(imageDataList, modelPage.getImageDataList());
    }
}
