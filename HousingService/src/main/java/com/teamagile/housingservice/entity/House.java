package com.teamagile.housingservice.entity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "House")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @ManyToOne
    @JoinColumn(name ="landlord_id")
    private Landlord landlordId;
    private String address;
    private Integer maxOccupant;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "houseId")
    private List<Facility> facilityList = new ArrayList<>();

    @Override
    public String toString() {
        return "House{" +
                "Id=" + Id +
                ", landlordId=" + landlordId +
                ", address='" + address + '\'' +
                ", maxOccupant=" + maxOccupant +
                ", landlord=" + landlordId +
                ", facilityList=" + facilityList +
                '}';
    }
}
