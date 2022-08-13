package com.teamagile.housingservice.entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Facility {
    private Integer Id;
    private Integer houseId;
    private String type;
    private String description;
    private Integer quantity;
}
