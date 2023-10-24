package com.service.car.Repositorioi;

import com.service.car.Entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer>{

    List<Carro> findByUsuarioId(int usuarioId);
}
