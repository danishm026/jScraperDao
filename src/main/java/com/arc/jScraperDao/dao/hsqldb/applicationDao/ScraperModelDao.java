package com.arc.jScraperDao.dao.hsqldb.applicationDao;

import com.arc.jScraperDao.dao.hsqldb.dbDao.ErrorImagePageDao;
import com.arc.jScraperDao.dao.hsqldb.dbDao.ErrorModelPageDao;
import com.arc.jScraperDao.dto.application.ImageData;
import com.arc.jScraperDao.dto.application.Model;
import com.arc.jScraperDao.dto.application.ModelPage;
import com.arc.jScraperDao.dto.db.ErrorImagePage;
import com.arc.jScraperDao.dto.db.ErrorModelPage;
import com.arc.jScraperDao.dto.db.ImageDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ScraperModelDao {
    private final JdbcTemplateModelDao jdbcTemplateModelDao;
    private final ErrorModelPageDao errorModelPageDao;
    private final ErrorImagePageDao errorImagePageDao;

    public void updateDBWithScraperModel(final Model model, final List<ErrorModelPage> errorModelPages, final List<ErrorImagePage> errorImagePages) {
        if (null == jdbcTemplateModelDao.load(model.getName())) {
            errorModelPageDao.save(errorModelPages);
            errorImagePageDao.save(errorImagePages);
        }
        jdbcTemplateModelDao.merge(model);
        for (ModelPage modelPage : model.getModelPages()) {
            errorModelPageDao.deleteByModelPageURL(Arrays.asList(modelPage.getModelPageURL()));
            for (ImageData imageData : modelPage.getImageDataList()) {
                errorImagePageDao.deletByImagePageURL(Arrays.asList(imageData.getImagePageURL()));
            }
        }
    }
}
