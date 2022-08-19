package com.teamagile.housingservice.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseAbstract implements Serializable {
    @Id
    private Integer Id;

    private LandlordAbstract landlord;

    private String address;

    private Integer maxOccupant;

    private List<FacilityAbstract> facilityList = new ArrayList<>();

}
