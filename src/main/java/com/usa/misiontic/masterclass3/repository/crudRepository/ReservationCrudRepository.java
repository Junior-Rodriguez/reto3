package com.usa.misiontic.masterclass3.repository.crudRepository;

import com.usa.misiontic.masterclass3.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    //J.R
//Metodos adicional en la interfaz de crudRepository
    //JPQL
    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by  COUNT(c.client) desc")

    public List<Object[]> countTotalReservatioByClient();

//Estos dos metodos son QUERY METHODS...
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    public List<Reservation> findAllByStatus(String status);
}
