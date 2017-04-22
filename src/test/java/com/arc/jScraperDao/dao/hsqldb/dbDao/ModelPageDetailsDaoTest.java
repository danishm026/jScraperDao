package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dto.db.ModelPageDetails;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 4/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcModelDaoTestConfig.xml")
public class ModelPageDetailsDaoTest {
    private static final String NAME = "testName";
    private static final int PAGE_NUMBER_1 = 1;
    private static final int STARTING_IMAGE_NUMBER_1 = 1;
    private static final int LAST_IMAGE_NUMBER_1 = 72;
    private static final int PAGE_NUMBER_2 = 2;
    private static final int STARTING_IMAGE_NUMBER_2 = 73;
    private static final int LAST_IMAGE_NUMBER_2 = 144;

    @Resource
    private ModelPageDetailsDao modelPageDetailsDao;

    @Before
    public void setup() {
        modelPageDetailsDao.createTable();
    }

    @Test
    public void testSaveAndLoad() {
        List<ModelPageDetails> modelPageDetailsList = getModelPageDetailsList();
        modelPageDetailsDao.save(modelPageDetailsList);
        List<ModelPageDetails> dbModelPageDetailsList = modelPageDetailsDao.load(NAME);

        for (int i = 0; i < dbModelPageDetailsList.size();i++) {
            assertEquals(modelPageDetailsList.get(i).getName(), dbModelPageDetailsList.get(i).getName());
            assertEquals(modelPageDetailsList.get(i).getPageNumber(), dbModelPageDetailsList.get(i).getPageNumber());
            assertEquals(modelPageDetailsList.get(i).getStartingImageNumber(), dbModelPageDetailsList.get(i).getStartingImageNumber());
            assertEquals(modelPageDetailsList.get(i).getLastImageNumber(), dbModelPageDetailsList.get(i).getLastImageNumber());
        }
    }

    private List<ModelPageDetails> getModelPageDetailsList() {
        return Arrays.asList(getModelPageDetails(NAME, PAGE_NUMBER_1, STARTING_IMAGE_NUMBER_1, LAST_IMAGE_NUMBER_1),
                getModelPageDetails(NAME, PAGE_NUMBER_2, STARTING_IMAGE_NUMBER_2, LAST_IMAGE_NUMBER_2));
    }

    private ModelPageDetails getModelPageDetails(String name, int pageNumber, int startingImageNumber, int lastImageNumber) {
        ModelPageDetails modelPageDetails = new ModelPageDetails();
        modelPageDetails.setName(name);
        modelPageDetails.setPageNumber(pageNumber);
        modelPageDetails.setStartingImageNumber(startingImageNumber);
        modelPageDetails.setLastImageNumber(lastImageNumber);
        return  modelPageDetails;
    }
}
