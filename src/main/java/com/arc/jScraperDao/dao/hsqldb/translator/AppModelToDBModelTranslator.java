package com.arc.jScraperDao.dao.hsqldb.translator;

import com.arc.jScraperDao.dto.application.ImageData;
import com.arc.jScraperDao.dto.application.Model;
import com.arc.jScraperDao.dto.application.ModelPage;
import com.arc.jScraperDao.dto.db.ImageDetails;
import com.arc.jScraperDao.dto.db.ModelDetails;
import com.arc.jScraperDao.dto.db.ModelPageDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppModelToDBModelTranslator {
    public ModelDetails getDBModelDetails(Model model) {
        ModelDetails modelDetails = new ModelDetails();
        modelDetails.setName(model.getName());
        modelDetails.setBaseUrl(model.getBaseUrl());
        modelDetails.setNumberOfPages(model.getNumberOfPages());
        modelDetails.setNumberOfImages(model.getNumberOfImages());
        return modelDetails;
    }

    public List<ModelPageDetails> getDBModelPages(Model model) {
        List<ModelPageDetails> modelPages = new ArrayList<>();
        for (ModelPage modelPage : model.getModelPages()) {
            ModelPageDetails modelPageDetails = new ModelPageDetails();
            modelPageDetails.setName(model.getName());
            modelPageDetails.setModelPageURL(modelPage.getModelPageURL());
            modelPageDetails.setPageNumber(modelPage.getPageNumber());
            modelPageDetails.setStartingImageNumber(modelPage.getStartingImageNumber());
            modelPageDetails.setLastImageNumber(modelPage.getLastImageNumber());
            modelPages.add(modelPageDetails);
        }
        return modelPages;
    }

    public List<ImageDetails> getDBImageDetails(Model model) {
        List<ImageDetails> imageDetailsList = new ArrayList<>();
        for (ModelPage modelPage : model.getModelPages()) {
            for(ImageData imageData : modelPage.getImageDataList()) {
                ImageDetails imageDetails = new ImageDetails();
                imageDetails.setName(model.getName());
                imageDetails.setPageNumber(modelPage.getPageNumber());
                imageDetails.setThumbnailURL(imageData.getThumbnailUrl());
                imageDetails.setImagePageURL(imageData.getImagePageURL());
                imageDetails.setImageURL(imageData.getImageUrl());
                imageDetailsList.add(imageDetails);
            }
        }
        return imageDetailsList;
    }

    public Model transformToAppModel(ModelDetails modelDetails, List<ModelPageDetails> modelPageDetailsList, List<ImageDetails> imageDetailsList) {
        if (null == modelDetails) {
            return null;
        }
        Model model = new Model();
        setModelDetails(model, modelDetails);
        setModelPages(model, modelPageDetailsList, imageDetailsList);
        return model;
    }

    private void setModelDetails(Model model, ModelDetails modelDetails) {
        model.setName(modelDetails.getName());
        model.setBaseUrl(modelDetails.getBaseUrl());
        model.setNumberOfPages(modelDetails.getNumberOfPages());
        model.setNumberOfImages(modelDetails.getNumberOfImages());
    }

    private void setModelPages(Model model, List<ModelPageDetails> modelPageDetailsList, List<ImageDetails> imageDetailsList) {
        List<ModelPage> modelPages = new ArrayList<>();
        Map<Integer, List<ImageData>> imageDataMap = getImageDetailsMap(imageDetailsList);
        for (ModelPageDetails modelPageDetails : modelPageDetailsList) {
            ModelPage modelPage = new ModelPage();
            modelPage.setModelPageURL(modelPageDetails.getModelPageURL());
            modelPage.setPageNumber(modelPageDetails.getPageNumber());
            modelPage.setStartingImageNumber(modelPageDetails.getStartingImageNumber());
            modelPage.setLastImageNumber(modelPageDetails.getLastImageNumber());
            modelPage.setImageDataList(imageDataMap.get(modelPageDetails.getPageNumber()));
            modelPages.add(modelPage);
        }
        model.setModelPages(modelPages);
    }

    private Map<Integer, List<ImageData>> getImageDetailsMap(List<ImageDetails> imageDetailsList) {
        Map<Integer, List<ImageData>> imageDataMap = new HashMap<>();
        for (ImageDetails imageDetails : imageDetailsList) {
            List<ImageData> imageDataListValue;
            if(imageDataMap.containsKey(imageDetails.getPageNumber())) {
                imageDataListValue = imageDataMap.get(imageDetails.getPageNumber());
            } else {
                imageDataListValue = new ArrayList<>();
            }
            imageDataListValue.add(transformToImageData(imageDetails));
            imageDataMap.put(imageDetails.getPageNumber(), imageDataListValue);
        }
        return imageDataMap;
    }

    private ImageData transformToImageData(ImageDetails imageDetails) {
        ImageData imageData = new ImageData();
        imageData.setThumbnailUrl(imageDetails.getThumbnailURL());
        imageData.setImagePageURL(imageDetails.getImagePageURL());
        imageData.setImageUrl(imageDetails.getImageURL());
        return imageData;
    }
}
