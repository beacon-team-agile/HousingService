package com.teamagile.housingservice.entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class House {
    private Integer Id;
    private Integer landlordId;
    private String address;
    private Integer maxOccupant;
}
