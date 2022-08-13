package com.teamagile.housingservice.entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacilityReportDetail {
    private Integer Id;
    private Integer facilityReportId;
    private Integer employeeId;
    private String comment;
    private Date createDate;
    private Date lastModificationDate;
}
