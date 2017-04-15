package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ModelPageDetailsTableQueries;
import com.arc.jScraperDao.dto.hsqldb.ModelPageDetails;
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

    public void save(List<ModelPageDetails> modelPageDetailsList) {
        jdbcTemplate.batchUpdate(ModelPageDetailsTableQueries.INSERT_QUERY, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                ModelPageDetails modelPageDetails = modelPageDetailsList.get(i);
                preparedStatement.setString(1, modelPageDetails.getName());
                preparedStatement.setString(2, modelPageDetails.getModelPageURL());
                preparedStatement.setInt(3, modelPageDetails.getPageNumber());
                preparedStatement.setInt(4, modelPageDetails.getStartingImageNumber());
                preparedStatement.setInt(5, modelPageDetails.getLastImageNumber());
            }

            @Override
            public int getBatchSize() {
                return modelPageDetailsList.size();
            }
        });
    }

    public List<ModelPageDetails> load(String name) {
        List<ModelPageDetails> modelPageDetailsList = jdbcTemplate.query(ModelPageDetailsTableQueries.QUERY_MODEL_PAGES_BY_NAME, new Object[]{name}, new BeanPropertyRowMapper<>(ModelPageDetails.class));
        return modelPageDetailsList;
    }
}
