package com.arc.jScraperDao.dao.hsqldb.applicationDao;

import com.arc.jScraperDao.dao.ModelDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ImageDetailsDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ModelDetailsDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ModelPageDetailsDao;
import com.arc.jScraperDao.dao.hsqldb.translator.AppModelToDBModelTranslator;
import com.arc.jScraperDao.dto.application.Model;
import com.arc.jScraperDao.dto.db.ImageDetails;
import com.arc.jScraperDao.dto.db.ModelDetails;
import com.arc.jScraperDao.dto.db.ModelPageDetails;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class JdbcTemplateModelDao implements ModelDao {
    private final ModelDetailsDao modelDetailsDao;
    private final ModelPageDetailsDao modelPageDetailsDao;
    private final ImageDetailsDao imageDetailsDao;
    private final AppModelToDBModelTranslator translator;

    @Override
    public void save(Model model) {
        if (isValidModel(model) && null == load(model.getName())) {
            modelDetailsDao.save(translator.getDBModelDetails(model));
            modelPageDetailsDao.save(translator.getDBModelPages(model));
            imageDetailsDao.save(translator.getDBImageDetails(model));
        }
    }

    @Override
    public Model load(String name) {
        ModelDetails modelDetails = modelDetailsDao.load(name);
        List<ModelPageDetails> modelPageDetailsList = modelPageDetailsDao.load(name);
        List<ImageDetails> imageDetailsList = imageDetailsDao.load(name);
        return translator.transformToAppModel(modelDetails, modelPageDetailsList, imageDetailsList);
    }

    public void merge(final Model model) {
        if (isValidModel(model)) {
            modelDetailsDao.merge(translator.getDBModelDetails(model));
            modelPageDetailsDao.merge(translator.getDBModelPages(model));
            imageDetailsDao.merge(translator.getDBImageDetails(model));
        }
    }

    private boolean isValidModel(@NonNull final Model model) {
        return !(null == model
                || null == model.getName()
                || null == model.getBaseUrl()
                || 0 == model.getNumberOfPages()
                || 0 == model.getNumberOfImages()
                || null == model.getModelPages()
                );
    }
}
