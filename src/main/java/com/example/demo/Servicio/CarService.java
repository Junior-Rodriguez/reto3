/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Repositorio.CarRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Modelo.Car;
/**
 *
 * @author USUARIO
 */

@Service

public class CarService {
      @Autowired
    private CarRepository carRepository;
    
    public List<Car> getAll(){
        return carRepository.getAll();
    }
    
    public Optional<Car> getCar(int id){
        return carRepository.getCar(id);
    }
    
    public Car save (Car car){
        if (car.getId() == null){
            return carRepository.save(car);
        } else {
            Optional<Car> tool1 = carRepository.getCar(car.getId());
            if(tool1.isEmpty()){
                return carRepository.save(car);
            } else {
                return car;
            }
        }
    }
}
