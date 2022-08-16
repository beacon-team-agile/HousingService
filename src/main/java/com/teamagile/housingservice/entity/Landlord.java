package com.teamagile.housingservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Landlord")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Landlord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    private String firstName;

    private String lastName;

    private String email;

    @Column(name = "cell_phone")
    private String cellPhone;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "landlordId", cascade = CascadeType.ALL, orphanRemoval = true)
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
