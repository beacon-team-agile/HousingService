package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.FacilityReport;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AllFacilityReportsResponse {
    private ResponseStatus responseStatus;
    private List<FacilityReport> facilityReportList;
}
