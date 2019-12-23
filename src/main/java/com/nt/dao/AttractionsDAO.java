package com.nt.dao;

import java.sql.SQLException;
import java.util.List;

import com.nt.bo.AttractionsBO;

public interface AttractionsDAO {

	public List<AttractionsBO> getAttractionsByState(String state) throws Exception;
	
}
