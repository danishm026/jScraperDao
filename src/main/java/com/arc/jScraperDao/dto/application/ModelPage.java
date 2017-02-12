package com.arc.jScraperDao.dto.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelPage {
    private int pageNumber;
    private int startingImageNumber;
    private int lastImageNumber;
    private List<ImageData> imageDataList;
}
