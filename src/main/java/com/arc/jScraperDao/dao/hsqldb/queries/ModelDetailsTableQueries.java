package com.arc.jScraperDao.dao.hsqldb.queries;

/**
 * Created by danish on 4/11/16.
 */
public class ModelDetailsTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS MODEL_DETAILS (" +
            "name                   varchar(255)," +
            "baseUrl                varchar(2083)," +
            "numberOfPages          integer," +
            "numberOfImages         integer," +
            "PRIMARY KEY (name)" +
            ");";

    public static final String INSERT_INTO_MODEL_DETAILS = "INSERT INTO MODEL_DETAILS " +
            "(name, baseUrl, numberOfPages, numberOfImages) VALUES (?, ?, ?, ?)";

    public static final String QUERY_BY_NAME = "SELECT * FROM MODEL_DETAILS WHERE name=? LIMIT 1";
}
