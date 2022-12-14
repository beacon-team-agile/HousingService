package com.teamagile.housingservice.entity;
import com.fasterxml.jackson.annotation.JsonCreator;
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
public class House implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="landlord_id")
    private Landlord landlordId;

    private String address;

    @Column(name = "max_occupant")
    private Integer maxOccupant;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "houseId")
    private List<Facility> facilityList = new ArrayList<>();


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

    @JsonCreator
    public House(@JsonProperty("housedId") Integer Id,
                    @JsonProperty("landlordId") Landlord landlordId,
                    @JsonProperty("address") String address,
                    @JsonProperty("maxOccupant") Integer maxOccupant){
        this.Id = Id;
        this.landlordId = landlordId;
        this.address = address;
        this.maxOccupant = maxOccupant;
    }
}
