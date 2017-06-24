package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dto.db.ErrorModelPage;
import com.arc.jScraperDao.util.TestConstants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcModelDaoTestConfig.xml")
public class ErrorModelPageDaoTest {
    @Autowired
    private ErrorModelPageDao errorModelPageDao;

    @Test
    public void saveAndLoadTest() {
        errorModelPageDao.save(getErrorModelPages());
        ErrorModelPage errorModelPage = errorModelPageDao.load(TestConstants.MODEL_NAME).get(0);
        assertEquals(TestConstants.MODEL_NAME, errorModelPage.getName());
        assertEquals(TestConstants.BASE_URL, errorModelPage.getModelPageURL());
        assertEquals(1, errorModelPage.getPageNumber());
    }

    @Test
    public void saveAndLoadWithEmptyListTest() {
        errorModelPageDao.save(new ArrayList<>());
    }

    private List<ErrorModelPage> getErrorModelPages() {
        ErrorModelPage errorModelPage = new ErrorModelPage();
        errorModelPage.setName(TestConstants.MODEL_NAME);
        errorModelPage.setModelPageURL(TestConstants.BASE_URL);
        errorModelPage.setPageNumber(1);
        return Arrays.asList(errorModelPage);
    }
}
