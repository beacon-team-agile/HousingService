package com.teamagile.housingservice.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Facility")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @ManyToOne
    @JoinColumn(name ="house_id")
    private House houseId;

    @Column(name = "`type`")
    private String type;

    @Column(name = "`description`")
    private String description;
    private Integer quantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facilityId")
    private List<FacilityReport> facilityReportList = new ArrayList<>();

    @Override
    public String toString() {
        return "Facility{" +
                "Id=" + Id +
                ", houseId=" + houseId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", house=" + houseId +
                ", facilityReportList=" + facilityReportList +
                '}';
    }
}
