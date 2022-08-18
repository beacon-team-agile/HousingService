package com.teamagile.housingservice.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
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
public class FacilityReport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="facility_id")
    private Facility facilityId;
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "title")
    private String title;

    @Column(name = "`description`")
    private String description;
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "`status`")
    private String status;
    @JsonIgnore
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

    @JsonCreator
    public FacilityReport(@JsonProperty("facilityReportId") Integer Id,
                        @JsonProperty("employeeId") String employeeId,
                        @JsonProperty("title") String title,
                        @JsonProperty("description") String description,
                        @JsonProperty("createDate") Date createDate,
                        @JsonProperty("status") String status){
        this.Id = Id;
        this.employeeId= employeeId;
        this.title = title;
        this.description = description;
        this.createDate = createDate;
        this.status = status;
    }
}
