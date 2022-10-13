package com.usa.misiontic.masterclass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "car")
@JsonPropertyOrder({  "idCar", "name", "brand", "year","description", "gama", "messages"})
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;
    private String name;
    private String brand;

    private Integer yearC;
    private String description;



/*
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "idGama")
    @JsonIgnoreProperties("cars")
    private List<Gama> gama;
    */

    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties("cars")
    private Gama gama;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "idMessage")
    @JsonIgnoreProperties("cars")
    private List<Message2> messages;
    /*
    @ManyToOne
    @JoinColumn(name = "idMessage")
    @JsonIgnoreProperties("car")
    private Message message;
*/
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "idReservation")
    @JsonIgnoreProperties("car")
    private List<Reservation> reservations;
    /*
    @ManyToOne
    @JoinColumn(name = "idReservation")
    @JsonIgnoreProperties("car")
    private Reservation reservations;
*/

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return yearC;
    }

    public void setYear(Integer year) {
        this.yearC = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public List<Message2> getMessages() {
        return messages;
    }

    public void setMessages(List<Message2> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }



}
