package com.teamagile.housingservice.entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Landlord {
    private Integer Id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellPhone;
}
