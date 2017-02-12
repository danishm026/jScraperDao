package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dto.hsqldb.ModelDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 4/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcModelDaoTestConfig.xml")
public class ModelDetailsDaoTest {
    private static final String MODEL_NAME = "testModelName";
    private static final String BASE_URL = "testBaseUrl";
    private static final int NUMBER_OF_PAGES = 3;
    private static final int NUMBER_OF_IMAGES = 209;

    @Resource
    private ModelDetailsDao modelDetailsDao;

    @Before
    public void setup() {
        modelDetailsDao.createModelDetailsTable();
    }

    @Test
    public void testSaveAndLoad() {
        ModelDetails modelDetails = getModel(MODEL_NAME, BASE_URL, NUMBER_OF_PAGES, NUMBER_OF_IMAGES);

        modelDetailsDao.save(modelDetails);
        ModelDetails dbModelDetails = modelDetailsDao.load(MODEL_NAME);

        assertEquals(MODEL_NAME, dbModelDetails.getName());
        assertEquals(BASE_URL, dbModelDetails.getBaseUrl());
        assertEquals(NUMBER_OF_PAGES, dbModelDetails.getNumberOfPages());
        assertEquals(NUMBER_OF_IMAGES, dbModelDetails.getNumberOfImages());
    }

    private ModelDetails getModel(String name, final String baseUrl, int numberOfPages, int numberOfImages) {
        ModelDetails modelDetails = new ModelDetails();
        modelDetails.setName(name);
        modelDetails.setBaseUrl(baseUrl);
        modelDetails.setNumberOfPages(numberOfPages);
        modelDetails.setNumberOfImages(numberOfImages);
        return modelDetails;
    }
}
