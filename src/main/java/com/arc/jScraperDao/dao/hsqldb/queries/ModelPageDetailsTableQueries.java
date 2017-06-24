package com.arc.jScraperDao.dao.hsqldb.queries;

public class ModelPageDetailsTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS MODEL_PAGE (" +
            "name                           varchar(255)," +
            "modelPageURL                   varchar(2083)," +
            "pageNumber                     integer," +
            "startingImageNumber            integer," +
            "lastImageNumber                integer," +
            "PRIMARY KEY (name, pageNumber)" +
            ");";

    public static final String INSERT_QUERY = "INSERT INTO MODEL_PAGE (name, modelPageURL, pageNumber, startingImageNumber, lastImageNumber)" +
            "VALUES (?, ?, ?, ?, ?);";

    public static final String QUERY_MODEL_PAGES_BY_NAME = "SELECT * FROM MODEL_PAGE " +
            "WHERE name=?;";

    public static final String MERGE_INTO_MAODEL_PAGE_DETAILS = "MERGE INTO MODEL_PAGE " +
            "USING (VALUES ?, ?, ?, ?, ?) TEMP (name, modelPageURL, pageNumber, startingImageNumber, lastImageNumber) " +
            "ON (MODEL_PAGE.modelPageURL = TEMP.modelPageURL) " +
            "WHEN NOT MATCHED THEN INSERT (name, modelPageURL, pageNumber, startingImageNumber, lastImageNumber) " +
            "VALUES (TEMP.name, TEMP.modelPageURL, TEMP.pageNumber, TEMP.startingImageNumber, TEMP.lastImageNumber)";
}
