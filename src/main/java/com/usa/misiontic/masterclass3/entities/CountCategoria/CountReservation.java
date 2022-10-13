package com.usa.misiontic.masterclass3.entities.CountCategoria;

import com.usa.misiontic.masterclass3.entities.Reservation;

//Esto no es una entidad es un comodin...para el arreglo de objetos
public class CountReservation {

    private long total;
    private Reservation reservation;

    public CountReservation(long total, Reservation reservation) {
        this.total = total;
        this.reservation = reservation;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
