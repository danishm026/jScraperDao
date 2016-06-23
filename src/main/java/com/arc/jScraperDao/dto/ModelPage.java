package com.arc.jScraperDao.dto;

import java.util.List;

public class ModelPage {
	private int pageNumber;
	private int startingImageNumber;
	private int lastImageNumber;
	private List<String> thumbnailsList;
	private List<String> imagePageLinkList;
	
	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNUmber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public int getStartingImageNumber() {
		return startingImageNumber;
	}
	
	public void setStartingImageNumber(int startingImageNumber) {
		this.startingImageNumber = startingImageNumber;
	}
	
	public int getLastImageNumber() {
		return lastImageNumber;
	}
	
	public void setLastImageNumber(int lastImageNumber) {
		this.lastImageNumber = lastImageNumber;
	}
	
	public List<String> getThumbnailsList() {
		return thumbnailsList;
	}
	
	public void setThumbnailsList(List<String> thumbnailsList) {
		this.thumbnailsList = thumbnailsList;
	}
	
	public List<String> getImagePageLinkList() {
		return imagePageLinkList;
	}
	
	public void setImagePageLinkList(List<String> imagePageLinkList) {
		this.imagePageLinkList = imagePageLinkList;
	}
}
