package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ImageDetailsTableQueries;
import com.arc.jScraperDao.dto.db.ImageDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ImageDetailsDao {
    @Getter
    @Setter(onMethod = @__({@Autowired}))
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.update(ImageDetailsTableQueries.CREATE_TABLE_QUERY);
    }

    public void save(final List<ImageDetails> imageDetailsList) {
        jdbcTemplate.batchUpdate(ImageDetailsTableQueries.INSERT_INTO_IMAGE_DETAILS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                setPreparedStatement(preparedStatement, imageDetailsList.get(i));
            }

            @Override
            public int getBatchSize() {
                return imageDetailsList.size();
            }
        });
    }

    public List<ImageDetails> load(final String name) {
        return jdbcTemplate.query(ImageDetailsTableQueries.QUERY_IMAGE_DETAILS_BY_NAME, new Object[] {name}, new BeanPropertyRowMapper<>(ImageDetails.class));
    }

    public void merge(final List<ImageDetails> imageDetailsList) {
        jdbcTemplate.batchUpdate(ImageDetailsTableQueries.MERGE_INT_IMAGE_DETAILS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                setPreparedStatement(preparedStatement, imageDetailsList.get(i));
            }

            @Override
            public int getBatchSize() {
                return imageDetailsList.size();
            }
        });
    }

    public void setPreparedStatement(final PreparedStatement preparedStatement, final ImageDetails imageDetails) throws SQLException {
        preparedStatement.setString(1, imageDetails.getName());
        preparedStatement.setInt(2, imageDetails.getPageNumber());
        preparedStatement.setString(3, imageDetails.getThumbnailURL());
        preparedStatement.setString(4, imageDetails.getImagePageURL());
        preparedStatement.setString(5, imageDetails.getImageURL());
    }
}
