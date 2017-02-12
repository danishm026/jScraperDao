package com.arc.jScraperDao.dao.hsqldb.applicationDao;

import com.arc.jScraperDao.dao.hsqldb.dbDao.ImageDetailsDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ModelDetailsDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ModelPageDetailsDao;
import com.arc.jScraperDao.dao.hsqldb.translator.AppModelToDBModelTranslator;
import com.arc.jScraperDao.dto.application.Model;
import com.arc.jScraperDao.dto.hsqldb.ModelDetails;
import com.arc.jScraperDao.util.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JdbcTemplateModelDaoTest {
    @Mock
    private ModelDetailsDao modelDetailsDao;
    @Mock
    private ModelPageDetailsDao modelPageDetailsDao;
    @Mock
    private ImageDetailsDao imageDetailsDao;
    @Mock
    private AppModelToDBModelTranslator translator;
    private JdbcTemplateModelDao jdbcTemplateModelDao;

    @Before
    public void setUp() {
        doNothing().when(modelDetailsDao).save(any(ModelDetails.class));
        doNothing().when(modelPageDetailsDao).save(any(List.class));
        doNothing().when(imageDetailsDao).save(any(List.class));
        doReturn(new ModelDetails()).when(modelDetailsDao).load(anyString());
        doReturn(new ArrayList<>()).when(modelPageDetailsDao).load(anyString());
        doReturn(new ArrayList<>()).when(imageDetailsDao).load(anyString());
        doReturn(new Model()).when(translator).transformToAppModel(any(ModelDetails.class), any(List.class), any(List.class));
        jdbcTemplateModelDao = new JdbcTemplateModelDao(modelDetailsDao, modelPageDetailsDao, imageDetailsDao, translator);
    }

    @Test
    public void saveTest() {
        jdbcTemplateModelDao.save(new Model());

        verify(modelDetailsDao).save(any(ModelDetails.class));
        verify(modelPageDetailsDao).save(any(List.class));
        verify(imageDetailsDao).save(any(List.class));
    }

    @Test
    public void loadTest() {
        jdbcTemplateModelDao.load(TestConstants.MODEL_NAME);

        verify(modelDetailsDao).load(TestConstants.MODEL_NAME);
        verify(modelPageDetailsDao).load(TestConstants.MODEL_NAME);
        verify(imageDetailsDao).load(TestConstants.MODEL_NAME);
        verify(translator).transformToAppModel(any(ModelDetails.class), any(List.class), any(List.class));
    }
}
