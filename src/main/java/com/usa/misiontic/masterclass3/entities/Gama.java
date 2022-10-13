package com.usa.misiontic.masterclass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "gama")
@JsonPropertyOrder({ "idGama", "name", "description"})
public class Gama implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGama;
    private String name;
    private String description;

/*
    @ManyToOne
    @JoinColumn(name = "gamaId")
    @JsonIgnoreProperties("gama")
    private Car car;
    */

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "idCar")
    @JsonIgnoreProperties("gama")
    private List<Car> car;

    public Integer getIdGama() {
        return idGama;
    }

    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Car> getCars() {
        return car;
    }

    public void setCars(List<Car> cars) {
        this.car = cars;
    }
}
