package com.arc.jScraperDao.dao.hsqldb.queries;

/**
 * Created by danish on 19/11/16.
 */
public class ImageDetailsTableQueries {
    public static final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS IMAGE_DETAILS (" +
            "name                   varchar(255)," +
            "pageNumber             integer," +
            "thumbnailUrl          integer(2083)," +
            "imageUrl         integer" +
            ");";

    public static final String INSERT_INTO_IMAGE_DETAILS = "INSERT INTO IMAGE_DETAILS " +
            "(name, pageNumber, thumbnailUrl, imageUrl) VALUES (?, ?, ?, ?);";

    public static final String QUERY_IMAGE_DETAILS_BY_NAME = "SELECT * FROM IMAGE_DETAILS WHERE name=?";
}
