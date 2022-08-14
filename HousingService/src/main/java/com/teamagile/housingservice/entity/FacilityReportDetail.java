package com.teamagile.housingservice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="FacilityReportDetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacilityReportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name ="facility_report_id")
    private FacilityReport facilityReportId;

    private Integer employeeId;

    @Column(name = "`comment`")
    private String comment;
    private Date createDate;
    private Date lastModificationDate;

}
