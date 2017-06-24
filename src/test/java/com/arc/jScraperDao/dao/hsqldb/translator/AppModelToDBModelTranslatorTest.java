package com.arc.jScraperDao.dao.hsqldb.translator;

import com.arc.jScraperDao.dto.application.ImageData;
import com.arc.jScraperDao.dto.application.ModelPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by danish on 12/2/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppModelToDBModelTranslatorTest {
    private List<ModelPage> modelPages;
    private List<ImageData> firstPageImageData;
    private List<ImageData> secondPageImageData;
    private AppModelToDBModelTranslator appModelToDBModelTranslator;

    @Test
    public void mockTest() {
    }
/*
    @Before
    public void setUp() {
        appModelToDBModelTranslator = new AppModelToDBModelTranslator();
        firstPageImageData = Arrays.asList(new ImageData(TestConstants.THUMBNAIL_URL_1, TestConstants.IMAGE_URL_1),
                new ImageData(TestConstants.THUMBNAIL_URL_2, TestConstants.IMAGE_URL_2));
        secondPageImageData = Arrays.asList(new ImageData(TestConstants.THUMBNAIL_URL_2, TestConstants.IMAGE_URL_2),
                new ImageData(TestConstants.THUMBNAIL_URL_1, TestConstants.IMAGE_URL_1));
        modelPages = Arrays.asList(new ModelPage(1, 1, 72, firstPageImageData),
                new ModelPage(2, 73, 144, secondPageImageData));
    }

    @Test
    public void getDBModelDetailsTest() {
        Model model = getModel();
        ModelDetails modelDetails = appModelToDBModelTranslator.getDBModelDetails(model);

        assertEquals(TestConstants.MODEL_NAME, modelDetails.getName());
        assertEquals(TestConstants.BASE_URL, modelDetails.getBaseUrl());
        assertEquals(TestConstants.NUMBER_OF_PAGES, modelDetails.getNumberOfPages());
        assertEquals(TestConstants.NUMBER_OF_IMAGES, modelDetails.getNumberOfImages());
    }

    @Test
    public void getDBModelPagesTest() {
        Model model = getModel();
        List<ModelPageDetails> modelPageDetailsList = appModelToDBModelTranslator.getDBModelPages(model);

        assertEquals(modelPages.size(), modelPageDetailsList.size());
        for (int i=0; i<modelPages.size(); i++) {
            assertEquals(model.getName(), modelPageDetailsList.get(i).getName());
            assertEquals(modelPages.get(i).getPageNumber(), modelPageDetailsList.get(i).getPageNumber());
            assertEquals(modelPages.get(i).getStartingImageNumber(), modelPageDetailsList.get(i).getStartingImageNumber());
            assertEquals(modelPages.get(i).getLastImageNumber(), modelPageDetailsList.get(i).getLastImageNumber());
        }
    }

    @Test
    public void getDBImageDetailsTest() {
        Model model = getModel();
        List<ImageDetails> imageDetailsList = appModelToDBModelTranslator.getDBImageDetails(model);

        assertEquals(firstPageImageData.size() + secondPageImageData.size(), imageDetailsList.size());
        Iterator<ImageDetails> imageDetailsIterator = imageDetailsList.iterator();
        for (int i=0; i<modelPages.size(); i++) {
            Iterator<ImageData> modelPageImageDataIterator = modelPages.get(i).getImageDataList().iterator();
            assertEquals(modelPageImageDataIterator.next().getThumbnailUrl(), imageDetailsIterator.next().getThumbnailUrl());
            assertEquals(modelPageImageDataIterator.next().getImageUrl(), imageDetailsIterator.next().getImageUrl());
        }
    }

    @Test
    public void transformToAppModelTest() {
        Model sourceModel = getModel();
        ModelDetails modelDetails = appModelToDBModelTranslator.getDBModelDetails(sourceModel);
        List<ModelPageDetails> modelPageDetailsList = appModelToDBModelTranslator.getDBModelPages(sourceModel);
        List<ImageDetails> imageDetailsList = appModelToDBModelTranslator.getDBImageDetails(sourceModel);
        Model transformedModel = appModelToDBModelTranslator.transformToAppModel(modelDetails, modelPageDetailsList, imageDetailsList);

        assertEquals(sourceModel.getName(), transformedModel.getName());
        assertEquals(sourceModel.getBaseUrl(), transformedModel.getBaseUrl());
        assertEquals(sourceModel.getNumberOfPages(), transformedModel.getNumberOfPages());
        assertEquals(sourceModel.getNumberOfImages(),transformedModel.getNumberOfImages());
        for (int i=0; i<sourceModel.getModelPages().size(); i++) {
            assertEquals(sourceModel.getModelPages().get(i).getPageNumber(), transformedModel.getModelPages().get(i).getPageNumber());
            assertEquals(sourceModel.getModelPages().get(i).getStartingImageNumber(), transformedModel.getModelPages().get(i).getStartingImageNumber());
            assertEquals(sourceModel.getModelPages().get(i).getLastImageNumber(), transformedModel.getModelPages().get(i).getLastImageNumber());
            for (int j=0; j<sourceModel.getModelPages().get(i).getImageDataList().size(); j++) {
                assertEquals(sourceModel.getModelPages().get(i).getImageDataList().get(j).getThumbnailUrl(), transformedModel.getModelPages().get(i).getImageDataList().get(j).getThumbnailUrl());
                assertEquals(sourceModel.getModelPages().get(i).getImageDataList().get(j).getImageUrl(), transformedModel.getModelPages().get(i).getImageDataList().get(j).getImageUrl());
            }
        }
    }

    private Model getModel(String name, String baseUrl, int numberOfPages, int numberOfImages, List<ModelPage> modelPages) {
        return new Model(name, baseUrl, numberOfPages, numberOfImages, modelPages);
    }

    private Model getModel() {
        return getModel(TestConstants.MODEL_NAME, TestConstants.BASE_URL,
                TestConstants.NUMBER_OF_PAGES, TestConstants.NUMBER_OF_IMAGES, modelPages);
    }
*/
}
