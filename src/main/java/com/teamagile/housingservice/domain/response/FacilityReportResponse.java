package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.FacilityReport;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FacilityReportResponse {
    private ResponseStatus responseStatus;
    private FacilityReport facilityReport;
}
