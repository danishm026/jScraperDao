package com.arc.jScraperDao.dao.hsqldb.queries;

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

    public static final String MERGE_INTO_MODEL_DETAILS = "MERGE INTO MODEL_DETAILS " +
            "USING (VALUES ?, ?, ?, ?) TEMP (name, baseUrl, numberOfPages, numberOfImages) " +
            "ON (MODEL_DETAILS.name = TEMP.name) " +
            "WHEN NOT MATCHED THEN INSERT (name, baseUrl, numberOfPages, numberOfImages) " +
            "VALUES (TEMP.name, TEMP.baseUrl, TEMP.numberOfPages, TEMP.numberOfImages)";
}
