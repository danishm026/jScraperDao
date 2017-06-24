package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ErrorImagePageTableQueries;
import com.arc.jScraperDao.dto.db.ErrorImagePage;
import lombok.Getter;
import lombok.NonNull;
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
public class ErrorImagePageDao {
    @Getter
    @Setter(onMethod = @__({@Autowired}))
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.batchUpdate(ErrorImagePageTableQueries.CREATE_TABLE_QUERY);
    }

    public void save(@NonNull final List<ErrorImagePage> errorImagePages) {
        if (null != errorImagePages && !errorImagePages.isEmpty()) {
            jdbcTemplate.batchUpdate(ErrorImagePageTableQueries.INSERT_QUERY, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    ErrorImagePage errorImagePage = errorImagePages.get(i);
                    preparedStatement.setString(1, errorImagePage.getName());
                    preparedStatement.setInt(2, errorImagePage.getModelPageNumber());
                    preparedStatement.setString(3, errorImagePage.getModelPageURL());
                    preparedStatement.setString(4, errorImagePage.getImagePageURL());
                }

                @Override
                public int getBatchSize() {
                    return errorImagePages.size();
                }
            });
        }
    }

    public List<ErrorImagePage> load (@NonNull final String name) {
        return jdbcTemplate.query(ErrorImagePageTableQueries.QUERY_IMAGE_DETAILS_BY_NAME, new Object[] {name}, new BeanPropertyRowMapper<>(ErrorImagePage.class));
    }

    public void deletByImagePageURL(final List<String> imagePageURLList) {
        jdbcTemplate.batchUpdate(ErrorImagePageTableQueries.DELETE_BY_IMAGE_PAGE_URL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, imagePageURLList.get(i));
            }

            @Override
            public int getBatchSize() {
                return imagePageURLList.size();
            }
        });
    }
}
