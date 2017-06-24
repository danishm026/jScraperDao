package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ModelPageDetailsTableQueries;
import com.arc.jScraperDao.dto.db.ModelPageDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ModelPageDetailsDao {
    @Getter
    @Setter(onMethod = @__({@Resource}))
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createTable() {
        jdbcTemplate.update(ModelPageDetailsTableQueries.CREATE_TABLE_QUERY);
    }

    public void save(final List<ModelPageDetails> modelPageDetailsList) {
        jdbcTemplate.batchUpdate(ModelPageDetailsTableQueries.INSERT_QUERY, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                setPreparedStatement(preparedStatement, modelPageDetailsList.get(i));
            }

            @Override
            public int getBatchSize() {
                return modelPageDetailsList.size();
            }
        });
    }

    public List<ModelPageDetails> load(final String name) {
        return jdbcTemplate.query(ModelPageDetailsTableQueries.QUERY_MODEL_PAGES_BY_NAME, new Object[]{name}, new BeanPropertyRowMapper<>(ModelPageDetails.class));
    }

    public void merge(final List<ModelPageDetails> modelPageDetailsList) {
        jdbcTemplate.batchUpdate(ModelPageDetailsTableQueries.MERGE_INTO_MAODEL_PAGE_DETAILS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                setPreparedStatement(preparedStatement, modelPageDetailsList.get(i));
            }

            @Override
            public int getBatchSize() {
                return  modelPageDetailsList.size();
            }
        });
    }

    private void setPreparedStatement(final PreparedStatement preparedStatement, final ModelPageDetails modelPageDetails) throws SQLException {
        preparedStatement.setString(1, modelPageDetails.getName());
        preparedStatement.setString(2, modelPageDetails.getModelPageURL());
        preparedStatement.setInt(3, modelPageDetails.getPageNumber());
        preparedStatement.setInt(4, modelPageDetails.getStartingImageNumber());
        preparedStatement.setInt(5, modelPageDetails.getLastImageNumber());
    }
}
