package com.arc.jScraperDao.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModelTest {
	@Mock
	List<ModelPage> modelPageList;
	
	@Test
	public void getAndSetNameTest() {
		Model model = new Model();
		String testName = "name";
		model.setName(testName);
		String actualName = model.getName();
		assertEquals(testName, actualName);
	}
	
	@Test
	public void getAndSetBaseUrlTest() {
		Model model = new Model();
		String testUrl = "http://www.google.co.in/";
		model.setBaseUrl(testUrl);
		String actualUrl = model.getBaseUrl();
		assertEquals(testUrl, actualUrl);
	}
	
	@Test
	public void getAndSetNumberOfPagesTest() {
		Model model = new Model();
		int testNumberOfPages = 19;
		model.setNumberOfPages(testNumberOfPages);
		int actualNumberOfPages = model.getNumberOfPages();
		assertEquals(testNumberOfPages, actualNumberOfPages);
	}
	
	@Test
	public void getAndSetNumberOfImagesTest() {
		Model model = new Model();
		int testNumberOfImages = 1234;
		model.setNumberOfImages(testNumberOfImages);
		int actualNumberOfImages = model.getNumberOfImages();
		assertEquals(testNumberOfImages, actualNumberOfImages);
	}	
	
	@Test
	public void getAndSetImageLinksTest() {
		Model model = new Model();
		List<String> list = new ArrayList<String>();
		
		model.setImageLinks(list);
		List<String> actualList = model.getImageLinks();
		
		assertEquals(list, actualList);
	}
	
	@Test
	public void getAndSetModelPagesTest() {
		Model model = new Model();
		model.setModelPages(modelPageList);
		List<ModelPage> actualModelPageList = model.getModelPages();
		assertEquals(modelPageList, actualModelPageList);
	}
}
