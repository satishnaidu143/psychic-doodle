package com.nt.service;

import java.util.List;

import com.nt.dto.AttractionsDTO;

public interface AttractionsService {


	public List<AttractionsDTO> searchAttractionsByState(String state) throws Exception;
	
}
