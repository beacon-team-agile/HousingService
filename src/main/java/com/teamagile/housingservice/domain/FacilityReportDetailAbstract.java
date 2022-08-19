package com.teamagile.housingservice.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.teamagile.housingservice.entity.FacilityReport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacilityReportDetailAbstract implements Serializable{

    private Integer Id;
    private Integer facilityReportId;

    private String employeeId;
    private String comment;
    private Date createDate;
    private Date lastModificationDate;
}
