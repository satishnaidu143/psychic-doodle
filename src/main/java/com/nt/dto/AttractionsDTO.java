package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AttractionsDTO implements Serializable{
	
	private int srNo;
	private int attractionid;
	private String attractionName;
	private String state;
	private String attractionType;
	private String timeToVisit;
	private String nearHotel;
	
	

}
