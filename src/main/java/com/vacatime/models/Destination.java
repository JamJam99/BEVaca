package com.vacatime.models;

import java.util.Set;

import javax.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "destination")

public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String city;
    private String description;

    @Override
    public String toString() {
        return "Destination{" + "id=" + id
        + ", cityname='" + city + '\''
        + '}'; 
    }

}