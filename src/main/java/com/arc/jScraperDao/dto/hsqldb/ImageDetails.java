package com.arc.jScraperDao.dto.hsqldb;

import lombok.Data;

/**
 * Created by danish on 19/11/16.
 */
@Data
public class ImageDetails {
    private String name;
    private int pageNumber;
    private String thumbnailUrl;
    private String imageUrl;
}
