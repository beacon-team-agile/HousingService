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
    private Integer landlordId;
    private String address;
    private Integer maxOccupant;

    @ManyToOne
    @JoinColumn(name ="landlord_id")
    private Landlord landlord;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
    private List<Facility> facilityList = new ArrayList<>();


}
