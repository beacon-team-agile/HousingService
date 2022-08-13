package com.teamagile.housingservice.entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacilityReport {
    private Integer Id;
    private Integer facilityId;
    private Integer employeeId;
    private String title;
    private String description;
    private Date createDate;
    private String status;
}
