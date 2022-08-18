package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FacilityReportDetailResponse {

    private ResponseStatus responseStatus;
    private FacilityReportDetail facilityReportDetail;
}
