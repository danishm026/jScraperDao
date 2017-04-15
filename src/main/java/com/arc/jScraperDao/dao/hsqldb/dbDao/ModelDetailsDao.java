package com.arc.jScraperDao.dao.hsqldb.dbDao;

import com.arc.jScraperDao.dao.hsqldb.queries.ModelDetailsTableQueries;
import com.arc.jScraperDao.dto.application.Model;
import com.arc.jScraperDao.dto.hsqldb.ModelDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Repository
public class ModelDetailsDao {
    @Getter
    @Setter(onMethod = @__({@Resource}))
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void createModelDetailsTable() {
        jdbcTemplate.update(ModelDetailsTableQueries.CREATE_TABLE_QUERY);
    }

    public void save(ModelDetails modelDetails) {
        jdbcTemplate.update(ModelDetailsTableQueries.INSERT_INTO_MODEL_DETAILS,
                modelDetails.getName(), modelDetails.getBaseUrl(), modelDetails.getNumberOfPages(), modelDetails.getNumberOfImages());
    }

    public ModelDetails load(String name) {
        List<ModelDetails> modelDetailsList = jdbcTemplate.query(ModelDetailsTableQueries.QUERY_BY_NAME, new Object[] {name}, new BeanPropertyRowMapper<>(ModelDetails.class));
        return modelDetailsList.isEmpty() ? null : modelDetailsList.get(0);
    }
}