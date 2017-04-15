package com.arc.jScraperDao.dao.hsqldb.queries;

/**
 * Created by danish on 19/11/16.
 */
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
}
