package com.modan_eng.modan.dao;

import java.util.List;
import com.modan_eng.modan.model.DataPointsModel;
import javax.sql.DataSource;

public interface DataPointsDAO 
{
    public List<DataPointsModel> getDataPoints();
    public void setDataSource(DataSource ds);
}