/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Interface.GamaInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.Modelo.Gama;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */

@Repository

public class GamaRepository {
    @Autowired
    private GamaInterface extencionesCrud;
    
    public List<Gama> getAll(){
        return (List<Gama>) extencionesCrud.findAll();
    }
    
    public Optional<Gama> getGama(int id){
        return extencionesCrud.findById(id);
    }
    
    public Gama save(Gama gama){
        return extencionesCrud.save(gama);
    }

}
