/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelo.Car;
import com.example.demo.Servicio.CarService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author USUARIO
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RequestMapping("/api/Car")


public class CarController {
      @Autowired
    private CarService carService;
    
    @GetMapping("/all")
    public List<Car> getAll(){
        return carService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Car> getCar(@PathVariable("id") int id){
        return carService.getCar(id);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Car save (@RequestBody Car tool){
        return carService.save(tool);
    }
}
