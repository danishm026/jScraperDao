package com.arc.jScraperDao.dao.hsqldb.queries;

/**
 * Created by danish on 4/11/16.
 */
public class ModelPageDetailsTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE MODEL_PAGE (" +
            "name                           varchar(255)," +
            "pageNumber                     integer," +
            "startingImageNumber            integer," +
            "lastImageNumber                integer," +
            "PRIMARY KEY (name, pageNumber)" +
            ");";

    public static final String INSERT_QUERY = "INSERT INTO MODEL_PAGE (name, pageNumber, startingImageNumber, lastImageNumber)" +
            "VALUES (?, ?, ?, ?);";

    public static final String QUERY_MODEL_PAGES_BY_NAME = "SELECT * FROM MODEL_PAGE " +
            "WHERE name=?;";
}
