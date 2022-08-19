package com.teamagile.housingservice.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacilityReportAbstract implements Serializable{
    @Id
    private Integer id;
    private Integer facilityId;
    private String employeeId;
    private String title;
    private String description;
    private Date createDate;
    private String status;
}
