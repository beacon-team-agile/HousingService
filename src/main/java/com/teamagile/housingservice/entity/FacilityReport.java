package com.teamagile.housingservice.entity;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="FacilityReport")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacilityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="facility_id")
    private Facility facilityId;
    @Column(name = "employee_id")
    private String employeeId;
    private String title;

    @Column(name = "`description`")
    private String description;
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "`status`")
    private String status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "facilityReportId")
    private List<FacilityReportDetail> facilityReportDetailList = new ArrayList<>();

    @Override
    public String toString() {
        return "FacilityReport{" +
                "Id=" + Id +
                ", facilityId=" + facilityId +
                ", employeeId='" + employeeId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", facilityReportDetailList=" + facilityReportDetailList +
                '}';
    }
}
