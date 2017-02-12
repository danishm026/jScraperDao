package com.arc.jScraperDao.dto.hsqldb;

import lombok.Data;

/**
 * Created by danish on 19/11/16.
 */
@Data
public class ModelDetails {
    private String name;
    private String baseUrl;
    private int numberOfPages;
    private int numberOfImages;
}
