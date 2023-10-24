package com.service.moto.Controller;

import com.service.moto.Entidades.Moto;
import com.service.moto.Servicios.MotoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("moto")
public class MotoController {

    @Autowired
    private MotoServicio motoServicio;


    @GetMapping
    public ResponseEntity<List<Moto>> listarMotos(){
        List<Moto> motos = motoServicio.getAll();
        if (motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> obtenerMoto(@PathVariable("id") int id ){
        Moto moto = motoServicio.getMotoById(id);
        if (moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }
    @PostMapping
    public ResponseEntity<Moto> guardarMoto(@RequestBody Moto moto){
        Moto newMoto1 = motoServicio.save(moto);
        return ResponseEntity.ok(newMoto1);

    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
        List<Moto> motos = motoServicio.byUsuarioId(id);
        if (motos == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(motos);


    }


}
