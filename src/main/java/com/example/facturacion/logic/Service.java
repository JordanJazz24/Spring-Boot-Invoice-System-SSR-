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
        Usuario usuario = usuarioRepository.findByidentificacion(identificacion);
        if (usuario != null) {
        Proveedor    proveedor= proveedorRepository.findByusuario(usuario);
            return proveedor;
            }

        return new Proveedor( );
    }

    public Iterable<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }
}
