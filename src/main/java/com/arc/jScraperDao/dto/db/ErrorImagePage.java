package com.arc.jScraperDao.dto.db;

import lombok.Data;

@Data
public class ErrorImagePage {
    private String name;
    private String modelPageURL;
    private int modelPageNumber;
    private String imagePageURL;
}
