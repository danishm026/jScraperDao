package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ImageDetailsTableQueries;
import com.arc.jScraperDao.dto.hsqldb.ImageDetails;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danish on 19/11/16.
 */
@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ImageDetailsDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(List<ImageDetails> imageDetailsList) {
        jdbcTemplate.batchUpdate(ImageDetailsTableQueries.INSERT_INTO_IMAGE_DETAILS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                ImageDetails imageDetails = imageDetailsList.get(i);
                preparedStatement.setString(1, imageDetails.getName());
                preparedStatement.setInt(2, imageDetails.getPageNumber());
                preparedStatement.setString(3, imageDetails.getThumbnailUrl());
                preparedStatement.setString(4, imageDetails.getImageUrl());
            }

            @Override
            public int getBatchSize() {
                return imageDetailsList.size();
            }
        });
    }

    public List<ImageDetails> load(String name) {
        return jdbcTemplate.query(ImageDetailsTableQueries.QUERY_IMAGE_DETAILS_BY_NAME, new Object[] {name}, new BeanPropertyRowMapper<>(ImageDetails.class));
    }
}
