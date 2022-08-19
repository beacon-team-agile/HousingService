package com.teamagile.housingservice.domain.response;

import com.teamagile.housingservice.domain.FacilityReportDetailAbstract;
import com.teamagile.housingservice.domain.common.ResponseStatus;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleFacilityReportDetailResponse implements Serializable {
    private ResponseStatus responseStatus;
    private FacilityReportDetailAbstract facilityReportDetail;
}
