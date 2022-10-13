package com.usa.misiontic.masterclass3.repository;


import com.usa.misiontic.masterclass3.entities.CountCategoria.CountReservation;
import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }

    public void delete(Reservation p){
        reservationCrudRepository.delete(p);
    }

//Nuevo J.R
    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);

    }
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }
    public List<CountReservation> getTopReservation(){
        List<CountReservation> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservatioByClient();
        for(int i=0; i < report.size(); i++){
            Reservation resr=(Reservation) report.get(i)[0];
            Long cantidad = (Long) report.get(i)[1];
            CountReservation cr = new CountReservation(cantidad, resr);
            res.add(cr);
        }

        return res;
    }

}
