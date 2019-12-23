package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nt.bo.AttractionsBO;
import com.nt.dto.AttractionsDTO;

@Repository("attrDao")
public class AttractionsDAOImp implements AttractionsDAO{

	@Autowired
	private DataSource ds;
	private static final String GETATTRACTIONS_QUERY="SELECT ATTRACTIONID,ATTRACTIONNAME,STATE,ATTRACTIONTYPE,TIMETOVISIT,NEARHOTEL FROM TOURISTPLACES WHERE STATE=?";
	
	public AttractionsDAOImp() {
		System.out.println("AttractionsDAOImp.AttractionsDAOImp()");
	}
	
	public List<AttractionsBO> getAttractionsByState(String state) throws SQLException {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AttractionsBO> attractionsDTO=new ArrayList<AttractionsBO>();
		
		con=ds.getConnection();
		ps=con.prepareStatement(GETATTRACTIONS_QUERY);
		ps.setString(1, state);
		rs=ps.executeQuery();
		
		while(rs.next())
		{
			AttractionsBO bo=new AttractionsBO();
			bo.setAttractionid(rs.getInt(1));
			bo.setAttractionName(rs.getString(2));
			bo.setAttractionType(rs.getString(4));
			bo.setState(rs.getString(3));
			bo.setTimeToVisit(rs.getString(5));
			bo.setNearHotel(rs.getString(6));
			
			attractionsDTO.add(bo);
		
		}
		
		return attractionsDTO;
	}


}
