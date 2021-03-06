package com.arc.jScraperDao.config;

import com.arc.jScraperDao.dao.hsqldb.applicationDao.JdbcTemplateModelDao;
import com.arc.jScraperDao.dao.hsqldb.applicationDao.ScraperModelDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ErrorImagePageDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ErrorModelPageDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.arc.jScraperDao.dao")
public class DataAccessConfig {
    @Bean
    public DriverManagerDataSource hsqldbDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        driverManagerDataSource.setUrl("jdbc:hsqldb:file:~/.scraper/db/hsqldb/data");
        driverManagerDataSource.setUsername("SA");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }

    @Bean
    @Resource
    public JdbcTemplate jdbcTemplate(final DriverManagerDataSource hsqldbDataSource) {
        return new JdbcTemplate(hsqldbDataSource);
    }

    @Bean
    @Resource
    public ScraperModelDao scraperModelDao(final JdbcTemplateModelDao jdbcTemplateModelDao, final ErrorModelPageDao errorModelPageDao, final ErrorImagePageDao errorImagePageDao) {
        return new ScraperModelDao(jdbcTemplateModelDao, errorModelPageDao, errorImagePageDao);
    }
}
