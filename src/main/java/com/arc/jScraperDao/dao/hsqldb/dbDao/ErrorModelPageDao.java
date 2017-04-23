package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ErrorModelPageTableQueries;
import com.arc.jScraperDao.dto.db.ErrorModelPage;
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
public class ErrorModelPageDao {
    @Getter
    @Setter(onMethod = @__({@Autowired}))
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.batchUpdate(ErrorModelPageTableQueries.CREATE_TABLE_QUERY);
    }

    public void save(@NonNull final List<ErrorModelPage> errorModelPages) {
        if (null != errorModelPages && !errorModelPages.isEmpty()) {
            jdbcTemplate.batchUpdate(ErrorModelPageTableQueries.INSERT_QUERY, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    ErrorModelPage errorModelPage = errorModelPages.get(i);
                    preparedStatement.setString(1, errorModelPage.getName());
                    preparedStatement.setString(2, errorModelPage.getModelPageURL());
                    preparedStatement.setInt(3, errorModelPage.getPageNumber());
                }

                @Override
                public int getBatchSize() {
                    return errorModelPages.size();
                }
            });
        }
    }

    public List<ErrorModelPage> load (@NonNull final String name) {
        return jdbcTemplate.query(ErrorModelPageTableQueries.QUERY_MODEL_PAGES_BY_NAME, new Object[] {name}, new BeanPropertyRowMapper<>(ErrorModelPage.class));
    }
}
