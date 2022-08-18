package com.teamagile.housingservice.domain.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class FacilityReportDetailRequest implements Serializable {
    private Integer facilityReportId;

    private String employeeId;

    private String comment;

}
