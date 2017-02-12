package com.arc.jScraperDao.dto.application;

import com.arc.jScraperDao.dto.application.Model;
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
public class ModelTest{
    @Mock
    private static List<ModelPage> modelPages;
    private static final String NAME = "testName";
    private static final String BASE_URL = "testBaseUrl";
    private static final int NUMBER_OF_PAGES = 5;
    private static final int NUMBER_OF_IMAGES = 268;

    @Test
    public void getAndSetNameTest() {
        Model model = new Model();
        model.setName(NAME);
        assertEquals(NAME, model.getName());
    }

    @Test
    public void getAndSetBaseUrlTest() {
        Model model = new Model();
        model.setBaseUrl(BASE_URL);
        assertEquals(BASE_URL, model.getBaseUrl());
    }

    @Test
    public void getAndSetNumberOfPages() {
        Model model = new Model();
        model.setNumberOfPages(NUMBER_OF_PAGES);
        assertEquals(NUMBER_OF_PAGES, model.getNumberOfPages());
    }

    @Test
    public void getAndSetNumberOfImagesTest() {
        Model model = new Model();
        model.setNumberOfImages(NUMBER_OF_IMAGES);
        assertEquals(NUMBER_OF_IMAGES, model.getNumberOfImages());
    }

    @Test
    public void getAndSetModelPageList() {
        Model model = new Model();
        model.setModelPages(modelPages);
        assertEquals(modelPages, model.getModelPages());
    }
}