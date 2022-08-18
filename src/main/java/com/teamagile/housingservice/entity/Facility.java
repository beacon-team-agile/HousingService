package com.teamagile.housingservice.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Facility")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Facility implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="house_id")
    private House houseId;

    @Column(name = "`type`")
    private String type;

    @Column(name = "`description`")
    private String description;
    private Integer quantity;
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "facilityId")
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

    @JsonCreator
    public Facility(@JsonProperty("facilityId") Integer Id,
                    @JsonProperty("houseId") House houseId,
                    @JsonProperty("type") String type,
                    @JsonProperty("description") String description,
                    @JsonProperty("quantity") Integer quantity){
        this.Id = Id;
        this.houseId = houseId;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
    }
}
