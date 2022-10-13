package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Client;
import com.usa.misiontic.masterclass3.entities.CountCategoria.CountReservation;
import com.usa.misiontic.masterclass3.entities.CountCategoria.StatusAmount;
import com.usa.misiontic.masterclass3.entities.Reservation;
import com.usa.misiontic.masterclass3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    //Reto 5 J.R
    @GetMapping("/report-status")
    public StatusAmount getReservationDescriptionStatus(){
        return reservationService.getStatusReport();
    }
    @GetMapping("/report-clients")
    public List<CountReservation> getCountClient(){
        return reservationService.getTopReservation();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2){
        return reservationService.getReservationPeriod(d1,d2);

    }
}
