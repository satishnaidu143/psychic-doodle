package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.nt.dto.AttractionsDTO;
import com.nt.service.AttractionsService;

@Component("mc")
@Lazy
public class MainController {

	@Autowired
	private AttractionsService service;

	public MainController() {
		System.out.println("MainController.MainController()");
		
	}
	
	public List<AttractionsDTO> readAttractionsByState(String state) throws Exception
	{
		List<AttractionsDTO> attractionsList=new ArrayList<AttractionsDTO>();
		
		attractionsList=service.searchAttractionsByState(state);
		return attractionsList;
	}
	
}
