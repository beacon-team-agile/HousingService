package com.teamagile.housingservice.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Landlord")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Landlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String firstName;
    private String lastName;
    private String email;
    private String cellPhone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlordId")
    private List<House> houseList = new ArrayList<>();

    @Override
    public String toString() {
        return "Landlord{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", houseList=" + houseList +
                '}';
    }
}
