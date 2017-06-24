package com.arc.jScraperDao.dao.hsqldb.queries;

public class ImageDetailsTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS IMAGE_DETAILS (" +
            "name                   varchar(255)," +
            "pageNumber             integer," +
            "thumbnailURL           varchar(2083)," +
            "imagePageURL           varchar(2083)," +
            "imageURL               varchar(2083)" +
            ");";

    public static final String INSERT_INTO_IMAGE_DETAILS = "INSERT INTO IMAGE_DETAILS " +
            "(name, pageNumber, thumbnailURL, imagePageURL, imageURL) VALUES (?, ?, ?, ?, ?);";

    public static final String QUERY_IMAGE_DETAILS_BY_NAME = "SELECT * FROM IMAGE_DETAILS WHERE name=?";

    public static final String MERGE_INT_IMAGE_DETAILS = "MERGE INTO IMAGE_DETAILS " +
            "USING (VALUES ?, ?, ?, ?, ?) TEMP (name, pageNumber, thumbnailURL, imagePageURL, imageURL) " +
            "ON (IMAGE_DETAILS.imageURL = TEMP.imageURL) " +
            "WHEN NOT MATCHED THEN INSERT (name, pageNumber, thumbnailURL, imagePageURL, imageURL) " +
            "VALUES (TEMP.name, TEMP.pageNumber, TEMP.thumbnailURL, TEMP.imagePageURL, TEMP.imageURL)";
}
