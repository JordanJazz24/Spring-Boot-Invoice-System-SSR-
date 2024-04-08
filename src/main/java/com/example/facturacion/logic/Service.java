package com.example.facturacion.logic;

import com.example.facturacion.data.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("Service")
public class Service {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
}
