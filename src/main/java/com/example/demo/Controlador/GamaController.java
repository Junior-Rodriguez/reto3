/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Servicio.GamaService;
import java.util.List;
import com.example.demo.Modelo.Gama;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Gama")

public class GamaController {
    @Autowired
    private GamaService gamaService;
    
    @GetMapping("/all")
    public List<Gama> getAll(){
        return gamaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable("id") Integer id){
        return gamaService.getGama(id);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save (@RequestBody Gama gama){
        return gamaService.save(gama);
    }
    
}
