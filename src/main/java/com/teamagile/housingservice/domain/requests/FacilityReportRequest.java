package com.teamagile.housingservice.domain.requests;

import java.io.Serializable;
import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FacilityReportRequest implements Serializable{
	private Integer facilityId;
	
	private String employeeId;
	
	private String title;
	
	private String description;
	
	private String status;
}
