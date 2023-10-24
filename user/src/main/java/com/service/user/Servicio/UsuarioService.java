package com.service.user.Servicio;

import com.service.user.Repository.UsuarioRepository;
import com.service.user.entidades.Usuario;
import com.service.user.modelos.Carro;
import com.service.user.modelos.Moto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Carro> getCarros(int usuarioId){
        List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
        return carros;
    }
    public List<Moto> getMotos(int usuarioId){
        List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
        return motos;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }
    public Usuario getUsuarioById(int id){
       return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario usuario){
           Usuario newUsuario = usuarioRepository.save(usuario);
           return newUsuario;
    }


}
