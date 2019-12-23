package com.nt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.AttractionsBO;
import com.nt.dao.AttractionsDAO;
import com.nt.dto.AttractionsDTO;

@Service("attrServ")
public class AttractionsServiceImp implements AttractionsService{

	//@Autowired
	private AttractionsDAO dao;

	public AttractionsServiceImp() {
		System.out.println("AttractionsServiceImp.AttractionsServiceImp()");
	}
	@Autowired
	public AttractionsServiceImp(AttractionsDAO dao) {
		this.dao=dao;
		System.out.println("AttractionsServiceImp.AttractionsServiceImp()");
	
	}
	//@Autowired
	public void setDao(AttractionsDAO dao) {
		this.dao = dao;
		System.out.println("AttractionsServiceImp.setDao()");
	}
	
	public List<AttractionsDTO> searchAttractionsByState(String state) throws Exception {
	
		List<AttractionsDTO> attractionsDTO=new ArrayList<AttractionsDTO>();
		List<AttractionsBO> attractionsBO=new ArrayList<AttractionsBO>();
		
		attractionsBO=dao.getAttractionsByState(state);
		
		for (AttractionsBO bo : attractionsBO) {
			AttractionsDTO dto=new AttractionsDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(attractionsDTO.size()+1);
			attractionsDTO.add(dto);
		}
		
		
		return attractionsDTO;
	}

}
