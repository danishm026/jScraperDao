package com.arc.jScraperDao.dto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModelPageTest {
	@Mock
	private ArrayList<String> mockedList;
	
	@Test
	public void getAndSetPageNumberTest() {
		ModelPage page = new ModelPage();
		
		int testPageNumber = 5;
		page.setPageNumber(testPageNumber);
		int actualPageNumber = page.getPageNumber();
		
		assertEquals(testPageNumber, actualPageNumber);
	}
	
	@Test
	public void getAndSetStartingImageNumberTest() {
		ModelPage page = new ModelPage();
		int testStartingImageNumber = 1;
		page.setStartingImageNumber(testStartingImageNumber);		
		assertEquals(testStartingImageNumber, page.getStartingImageNumber());
	}
	
	@Test
	public void getAndSetLastImageNumberTest() {
		ModelPage page = new ModelPage();
		int testLastImageNumber = 71;
		page.setLastImageNumber(testLastImageNumber);		
		assertEquals(testLastImageNumber, page.getLastImageNumber());
	}
	
	@Test
	public void getAndSetThumbnailsListTest() {
		ModelPage page = new ModelPage();
		
		page.setThumbnailsList(mockedList);
		assertEquals(mockedList, page.getThumbnailsList());
		
	}
	
	@Test
	public void getAndSetImagePageLinkListTest() {
		ModelPage page = new ModelPage();
		
		page.setImagePageLinkList(mockedList);
		assertEquals(mockedList, page.getImagePageLinkList());
		
	}
}
