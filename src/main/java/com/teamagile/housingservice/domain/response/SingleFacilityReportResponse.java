package com.teamagile.housingservice.domain.response;

import java.io.Serializable;

import com.teamagile.housingservice.domain.FacilityReportAbstract;
import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.FacilityReport;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleFacilityReportResponse implements Serializable{
    private ResponseStatus responseStatus;
    private FacilityReportAbstract facilityReport;
}
