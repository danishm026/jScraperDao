package com.arc.jScraperDao.dao.hsqldb.queries;

public class ErrorModelPageTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS ERROR_MODEL_PAGE (" +
            "name                           varchar(255)," +
            "modelPageURL                   varchar(2083)," +
            "pageNumber                     integer" +
            ");";

    public static final String INSERT_QUERY = "INSERT INTO ERROR_MODEL_PAGE (name, modelPageURL, pageNumber) " +
            "VALUES (?, ?, ?);";

    public static final String QUERY_MODEL_PAGES_BY_NAME = "SELECT * FROM ERROR_MODEL_PAGE " +
            "WHERE name=?;";
}
