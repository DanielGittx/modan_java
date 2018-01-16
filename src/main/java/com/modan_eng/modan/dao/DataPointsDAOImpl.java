package com.modan_eng.modan.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.modan_eng.modan.model.DataPointsModel;
import com.modan_eng.modan.services.DataPointsMapper;

public class DataPointsDAOImpl implements DataPointsDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	public List<DataPointsModel> getDataPoints() {
		String SQL = "select * from canvasjs_db.datapoints";
		List<DataPointsModel> dataPoints = jdbcTemplateObject.query(SQL, new DataPointsMapper());
		return dataPoints;
	}
}
