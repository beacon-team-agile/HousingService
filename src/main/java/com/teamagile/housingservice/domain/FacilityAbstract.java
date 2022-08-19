package com.teamagile.housingservice.domain;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacilityAbstract implements Serializable {

    private Integer Id;
    
    private Integer houseId;

    private String type;

    private String description;
    
    private Integer quantity;
    
}
