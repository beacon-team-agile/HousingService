package com.teamagile.housingservice.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Cascade;

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
public class HouseAbstract implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="landlord_id")
    private LandlordAbstract landlordId;

    private String address;

    @Column(name = "max_occupant")
    private Integer maxOccupant;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "houseId")
    private List<FacilityAbstract> facilityList = new ArrayList<>();


    @Override
    public String toString() {
        return "House{" +
                "Id=" + Id +
                ", landlordId=" + landlordId +
                ", address='" + address + '\'' +
                ", maxOccupant=" + maxOccupant +
                ", facilityList=" + facilityList +
                '}';
    }
}
