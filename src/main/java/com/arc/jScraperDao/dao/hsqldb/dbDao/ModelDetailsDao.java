package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ModelDetailsTableQueries;
import com.arc.jScraperDao.dto.hsqldb.ModelDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by danish on 4/11/16.
 */
@Repository
public class ModelDetailsDao {
    @Getter
    @Setter(onMethod = @__({@Resource}))
    private JdbcTemplate jdbcTemplate;

    public void createModelDetailsTable() {
        jdbcTemplate.update(ModelDetailsTableQueries.CREATE_TABLE_QUERY);
    }

    public void save(ModelDetails modelDetails) {
        jdbcTemplate.update(ModelDetailsTableQueries.INSERT_INTO_MODEL_DETAILS,
                modelDetails.getName(), modelDetails.getBaseUrl(), modelDetails.getNumberOfPages(), modelDetails.getNumberOfImages());
    }

    public ModelDetails load(String name) {
        return jdbcTemplate.queryForObject(ModelDetailsTableQueries.QUERY_BY_NAME, new Object[] {name},
                (resultSet , i) -> {
                    ModelDetails modelDetails = new ModelDetails();
                    modelDetails.setName(resultSet.getString("name"));
                    modelDetails.setBaseUrl(resultSet.getString("baseUrl"));
                    modelDetails.setNumberOfPages(resultSet.getInt("numberOfPages"));
                    modelDetails.setNumberOfImages(resultSet.getInt("numberOfImages"));
                    return modelDetails;
                });
    }
}