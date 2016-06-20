package com.arc.jScraperDao.dto;

import java.util.List;

public class Model {
	private String name;
	private String baseUrl;
	private int numberOfPages;
	private int numberOfImages;
	private List<ModelPage> modelPages;
	private List<String> imageLinks;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public int getNumberOfImages() {
		return numberOfImages;
	}
	
	public void setNumberOfImages(int numberOfImages) {
		this.numberOfImages = numberOfImages;
	}
	
	public List<ModelPage> getModelPages() {
		return modelPages;
	}

	public void setModelPages(List<ModelPage> modelPages) {
		this.modelPages = modelPages;
	}

	public List<String> getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(List<String> imageLinks) {
		this.imageLinks = imageLinks;
	}
}
