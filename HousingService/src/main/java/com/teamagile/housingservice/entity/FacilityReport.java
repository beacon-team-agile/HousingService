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
    @ManyToOne
    @JoinColumn(name ="facility_id")
    private Facility facilityId;
    private Integer employeeId;
    private String title;

    @Column(name = "`description`")
    private String description;
    private Date createDate;

    @Column(name = "`status`")
    private String status;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityReportId")
    private List<FacilityReportDetail> facilityReportDetailList = new ArrayList<>();

    @Override
    public String toString() {
        return "FacilityReport{" +
                "Id=" + Id +
                ", facilityId=" + facilityId +
                ", employeeId=" + employeeId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", status='" + status + '\'' +
                ", facility=" + facilityId +
                ", facilityReportDetailList=" + facilityReportDetailList +
                '}';
    }
}
