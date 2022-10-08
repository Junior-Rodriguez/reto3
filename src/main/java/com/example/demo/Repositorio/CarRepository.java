/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.CarInterface;
import org.springframework.stereotype.Repository;
import com.example.demo.Modelo.Car;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author USUARIO
 */

@Repository

public class CarRepository {
     @Autowired
    private CarInterface extencionesCrud;
    
    public List<Car> getAll(){
        return (List<Car>) extencionesCrud.findAll();
    }
    
    public Optional<Car> getCar(int id){
        return extencionesCrud.findById(id);
    }
    
    public Car save(Car car){
        return extencionesCrud.save(car);
    }
}
