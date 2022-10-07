/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Repositorio.GamaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Modelo.Gama;
import java.util.Optional;
/**
 *
 * @author USUARIO
 */

@Service

public class GamaService {
    @Autowired
    private GamaRepository gamaRepository;
    
    public List<Gama> getAll(){
        return gamaRepository.getAll();
    }
    
    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }
    
    public Gama save (Gama gama){
        if (gama.getId() == null){
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> gama1 = gamaRepository.getGama(gama.getId());
            if(gama1.isEmpty()){
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }
}
