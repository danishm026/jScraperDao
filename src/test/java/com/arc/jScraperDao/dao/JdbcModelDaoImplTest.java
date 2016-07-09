package com.arc.jScraperDao.dao;

import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arc.jScraperDao.dto.Model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:jdbcModelDaoTestConfig.xml")
public class JdbcModelDaoImplTest {
	@Autowired
	private ModelDao jdbcModelDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Model model;

	private void createSchema() {
		final String createModelTableQuery = "CREATE TABLE MODEL ( \n" + "        id                int IDENTITY,\n"
				+ "        name              varchar(255),\n" + "        basePageUrl       varchar(1000),\n"
				+ "        noOfPages         int,\n" + "        noOfImages        int,\n"
				+ "        primary key       (id)\n" + "     );";

		final String createPhotosPerPageTableQuery = "CREATE TABLE PHOTOS_PER_PAGE (\n"
				+ "                                       id                  int,\n"
				+ "                                       pageNo              int,\n"
				+ "                                       imagesOnpage        int,\n"
				+ "                                       startImageNumber    int,\n"
				+ "                                       endImageNumber      int\n"
				+ "                                    );";

		final String createImageLinksTableQuery = "CREATE TABLE IMAGE_LINKS (\n"
				+ "                                        id                int,\n"
				+ "                                        imageLink         varchar(1000)\n"
				+ "                                    );";

		final String createThumbnailsOnPageTableQuery = "CREATE TABLE THUMBNAILS_ON_PAGE (\n" + "  id int,\n"
				+ "  pageNo int,\n" + "  thumbnailUrl varchar(1000),\n" + "  imagePageUrl varchar(1000)\n" + ");";
		
		jdbcTemplate.update(createModelTableQuery);
		jdbcTemplate.update(createPhotosPerPageTableQuery);
		jdbcTemplate.update(createImageLinksTableQuery);
		jdbcTemplate.update(createThumbnailsOnPageTableQuery);
	}

	@Test
	public void saveModelTest() {
		createSchema();
		jdbcModelDao.saveModel(model);
		List<Model> models = jdbcTemplate.query("Select * from MODEL where name = 'testName'", new RowMapper<Model>() {

			@Override
			public Model mapRow(ResultSet rs, int rowNum) throws SQLException {
				Model modelFromDB = new Model();
				modelFromDB.setName(rs.getString("name"));
				modelFromDB.setBaseUrl(rs.getString("basePageUrl"));
				modelFromDB.setNumberOfPages(rs.getInt("noOfPages"));
				modelFromDB.setNumberOfImages(rs.getInt("noOfImages"));
				return modelFromDB;
			}
		});
		
		assertEquals(models.size(), 1);
		
		Model modelFromDB = models.get(0);
		assertEquals(model.getName(), modelFromDB.getName());
		assertEquals(model.getBaseUrl(), modelFromDB.getBaseUrl());
		assertEquals(model.getNumberOfPages(), modelFromDB.getNumberOfPages());
		assertEquals(model.getNumberOfImages(), modelFromDB.getNumberOfImages());
		
		Model model = jdbcModelDao.getModelByName("testName");
		assertEquals(model.getBaseUrl(), "testBaseUrl");
	}
}
