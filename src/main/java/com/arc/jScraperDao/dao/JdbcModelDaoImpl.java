package com.arc.jScraperDao.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.arc.jScraperDao.dto.Model;
import com.arc.jScraperDao.dto.ModelPage;

@Repository
public class JdbcModelDaoImpl implements ModelDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String MODEL_TABLE_INSERT_QUERY = "INSERT INTO MODEL "
			+ "(name, basePageUrl, noOfpages, noOfimages)" + " VALUES (?, ?, ?, ?)";
	private static final String IMAGE_LINKS_TABLE_INSERT_QUERY = "INSERT INTO IMAGE_LINKS" + "(id, imageLink)"
			+ "VALUES (?, ?)";

	private static final String PHOTOS_PER_PAGE_TABLE_INSERT_QUERY = "INSERT INTO PHOTOS_PER_PAGE"
			+ "(id, pageNo, imagesOnpage, startImageNumber, endImageNumber)" + "VALUES (?, ?, ?, ?, ?)";

	private static final String THUMBNAILS_ON_PAGE_TABLE_INSERT_QUERY = "INSERT INTO THUMBNAILS_ON_PAGE"
			+ "(id, pageNo, thumbnailUrl, imagePageUrl)" + "VALUES (?, ?, ?, ?)";

	private static final String ID_FROM_NAME_QUERY = "SELECT id from MODEL WHERE name = ?";

	private static final String MODEL_TABLE_QUERY_BY_NAME = "SELECT * FROM MODEL WHERE name = ?";

	private static final String IMAGE_LINKS_QUERY = "SELECT * FROM IMAGE_LINKS WHERE id = ?";

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private void insertIntoModelTable(Model model) {
		String name = model.getName();
		String basePageUrl = model.getBaseUrl();
		int noOfPages = model.getNumberOfPages();
		int noOfImages = model.getNumberOfImages();

		jdbcTemplate.update(MODEL_TABLE_INSERT_QUERY, name, basePageUrl, noOfPages, noOfImages);
	}

	private void insertIntoImageLnksTable(final Model model) {
		String name = model.getName();
		final int id = getIdByName(name);

		jdbcTemplate.batchUpdate(IMAGE_LINKS_TABLE_INSERT_QUERY, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				String imageLink = model.getImageLinks().get(i);
				ps.setInt(1, id);
				ps.setString(2, imageLink);
			}

			@Override
			public int getBatchSize() {
				return model.getImageLinks().size();
			}
		});

	}

	private void insertIntoPhotosPerPageTable(final Model model) {
		String name = model.getName();
		final int id = getIdByName(name);
		jdbcTemplate.batchUpdate(PHOTOS_PER_PAGE_TABLE_INSERT_QUERY, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				int pageNo = model.getModelPages().get(i).getPageNumber();
				int startImageNumber = model.getModelPages().get(i).getStartingImageNumber();
				int endImageNumber = model.getModelPages().get(i).getLastImageNumber();
				int imagesOnpage = endImageNumber - startImageNumber + 1;

				ps.setInt(1, id);
				ps.setInt(2, pageNo);
				ps.setInt(3, imagesOnpage);
				ps.setInt(4, startImageNumber);
				ps.setInt(5, endImageNumber);
			}

			@Override
			public int getBatchSize() {
				return model.getModelPages().size();
			}
		});
	}

	private void insertIntoThumbnailsOnPageTable(final Model model) {
		String name = model.getName();
		final int id = getIdByName(name);
		for (final ModelPage modelPage : model.getModelPages()) {
			jdbcTemplate.batchUpdate(THUMBNAILS_ON_PAGE_TABLE_INSERT_QUERY, new BatchPreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					String thumbnailUrl = modelPage.getThumbnailsList().get(i);
					String imagePageUrl = modelPage.getImagePageLinkList().get(i);
					ps.setInt(1, id);
					ps.setInt(2, modelPage.getPageNumber());
					ps.setString(3, thumbnailUrl);
					ps.setString(4, imagePageUrl);
				}

				@Override
				public int getBatchSize() {
					return modelPage.getThumbnailsList().size();
				}
			});
		}
	}

	@Override
	public int getIdByName(String name) {
		int id = jdbcTemplate.query(ID_FROM_NAME_QUERY, new Object[] { name }, new ResultSetExtractor<Integer>() {
			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next())
					return rs.getInt("id");
				return -1;
			}
		});
		return id;
	}

	@Override
	public void saveModel(final Model model) {
		insertIntoModelTable(model);
		insertIntoImageLnksTable(model);
		insertIntoPhotosPerPageTable(model);
		insertIntoThumbnailsOnPageTable(model);
	}

	@Override
	public Model getModelByName(String name) {
		Model model = new Model();
		int id = getIdByName(name);
		Model tempModel = jdbcTemplate.query(MODEL_TABLE_QUERY_BY_NAME, new String[] { name },
				new ResultSetExtractor<Model>() {

					@Override
					public Model extractData(ResultSet rs) throws SQLException, DataAccessException {
						if (rs.next()) {
							Model model = new Model();
							String name = rs.getString("name");
							String baseUrl = rs.getString("basePageUrl");
							int noOfPages = rs.getInt("noOfPages");
							int noOfImages = rs.getInt("noOfImages");

							model.setName(name);
							model.setBaseUrl(baseUrl);
							model.setNumberOfPages(noOfPages);
							model.setNumberOfImages(noOfImages);
							return model;
						}
						return null;
					}
				});

		model.setName(tempModel.getName());
		model.setBaseUrl(tempModel.getBaseUrl());
		model.setNumberOfPages(tempModel.getNumberOfPages());
		model.setNumberOfImages(tempModel.getNumberOfImages());
		return model;
	}
}
