package com.arc.jScraperDao.dao.hsqldb.queries;

public class ErrorImagePageTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS ERROR_IMAGE_PAGE (" +
            "name                   varchar(255)," +
            "pageNumber             integer," +
            "modelPageURL           varchar(2083)," +
            "imagePageURL           varchar(2083)" +
            ");";

    public static final String INSERT_QUERY = "INSERT INTO ERROR_IMAGE_PAGE " +
            "(name, pageNumber, modelPageURL, imagePageURL) VALUES (?, ?, ?, ?);";

    public static final String QUERY_IMAGE_DETAILS_BY_NAME = "SELECT * FROM ERROR_IMAGE_PAGE WHERE name=?";
}