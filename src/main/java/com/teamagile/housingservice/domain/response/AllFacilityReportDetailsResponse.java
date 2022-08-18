package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.domain.common.ResponseStatus;
import com.teamagile.housingservice.entity.FacilityReportDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class AllFacilityReportDetailsResponse {
    private ResponseStatus responseStatus;
    private List<FacilityReportDetail> facilityReportDetailList;
}
