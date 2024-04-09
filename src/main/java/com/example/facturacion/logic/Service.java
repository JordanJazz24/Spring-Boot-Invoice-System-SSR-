package com.example.facturacion.logic;

import com.example.facturacion.data.ProveedorRepository;
import com.example.facturacion.data.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("Service")
public class Service {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario usuarioRead(String identificacion) {
        return usuarioRepository.findByidentificacion(identificacion);
    }

    public Proveedor proveedorRead(String identificacion) {
        // Busca el usuario con la identificación dada
        Usuario usuario = usuarioRepository.findByidentificacion(identificacion);

        // Si se encuentra el usuario, busca el proveedor asociado a ese usuario
        if (usuario != null) {
            return proveedorRepository.findByUsuario_Identificacion(identificacion);
        }

        // Si no se encuentra el usuario, devuelve null o lanza una excepción, según tu lógica de negocio
        return null; // o lanza una excepción
    }

}
