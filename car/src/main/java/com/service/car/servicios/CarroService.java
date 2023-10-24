package com.service.car.servicios;

import com.service.car.Entidades.Carro;
import com.service.car.Repositorioi.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {public List<Carro> getAll(){
    return carroRepository.findAll();
}
    public Carro getCarroById(int id){
        return carroRepository.findById(id).orElse(null);
    }
    public Carro save(Carro carro){
        Carro newCarro = carroRepository.save(carro);
        return newCarro;
    }
    public List<Carro> byUsuarioId(int usuarioId){
        return carroRepository.findByUsuarioId(usuarioId);
    }

    @Autowired
    private CarroRepository carroRepository;












}
