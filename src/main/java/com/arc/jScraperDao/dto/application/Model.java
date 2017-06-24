package com.arc.jScraperDao.dto.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Model {
	private String name;
	private String baseUrl;
	private int numberOfPages;
	private int numberOfImages;
	private List<ModelPage> modelPages;
}
