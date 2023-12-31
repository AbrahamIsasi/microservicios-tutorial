package com.service.moto.Servicios;

import com.service.moto.Entidades.Moto;
import com.service.moto.Repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoServicio {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getAll(){
        return motoRepository.findAll();
    }
    public Moto getMotoById(int id){
        return motoRepository.findById(id).orElse(null);
    }
    public Moto save(Moto moto){
        Moto newMoto = motoRepository.save(moto);
        return newMoto;
    }
    public List<Moto> byUsuarioId(int usuarioId){
        return motoRepository.findByUsuarioId(usuarioId);
    }











}
