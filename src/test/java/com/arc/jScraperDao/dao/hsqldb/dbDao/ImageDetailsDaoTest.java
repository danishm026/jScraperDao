package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ImageDetailsTableQueries;
import com.arc.jScraperDao.dto.hsqldb.ImageDetails;
import com.arc.jScraperDao.util.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by danish on 5/2/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class ImageDetailsDaoTest {
    @Mock
    private JdbcTemplate jdbcTemplate;
    private ImageDetailsDao imageDetailsDao;

    @Before
    public void setUp() {
        doReturn(new int[] {1}).when(jdbcTemplate).batchUpdate(anyString(), any(BatchPreparedStatementSetter.class));
        doReturn(new ArrayList<>()).when(jdbcTemplate).query(anyString(), any(Object[].class), any(BeanPropertyRowMapper.class));
        imageDetailsDao = new ImageDetailsDao(jdbcTemplate);
    }

    @Test
    public void saveTest() {
        List<ImageDetails> imageDetailsList = new ArrayList<>();
        imageDetailsDao.save(imageDetailsList);

        verify(jdbcTemplate).batchUpdate(eq(ImageDetailsTableQueries.INSERT_INTO_IMAGE_DETAILS), any(BatchPreparedStatementSetter.class));
    }

    @Test
    public void loadTest() {
        imageDetailsDao.load(TestConstants.MODEL_NAME);

        verify(jdbcTemplate).query(eq(ImageDetailsTableQueries.QUERY_IMAGE_DETAILS_BY_NAME), any(Object[].class), any(BeanPropertyRowMapper.class));
    }
}
