package com.teamagile.housingservice.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="FacilityReportDetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FacilityReportDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="facility_report_id")
    private FacilityReport facilityReportId;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "`comment`")
    private String comment;
    @Column(name="create_date")
    private Date createDate;
    @Column(name = "last_modification_date")
    private Date lastModificationDate;

}
