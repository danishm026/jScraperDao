package com.arc.jScraperDao.dto.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by danish on 19/11/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageData {
    private String thumbnailUrl;
    private String imagePageURL;
    private String imageUrl;
}
