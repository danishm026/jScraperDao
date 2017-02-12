package com.arc.jScraperDao.dao;

import com.arc.jScraperDao.dto.application.Model;

public interface ModelDao {
    void save(Model model);
    Model load(String name);
}