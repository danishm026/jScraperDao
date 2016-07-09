package com.arc.jScraperDao.dao;

import com.arc.jScraperDao.dto.Model;

public interface ModelDao {
	public int getIdByName(String name);
	public void saveModel(Model model);
	public Model getModelByName(String name);
}
