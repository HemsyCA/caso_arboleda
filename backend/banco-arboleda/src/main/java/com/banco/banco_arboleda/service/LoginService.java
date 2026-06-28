package com.banco.banco_arboleda.service;

import com.banco.banco_arboleda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository repository;

    public boolean validar(String usuario, String clave) {
        return repository.findByUsuarioAndClave(usuario, clave).isPresent();
    }
}