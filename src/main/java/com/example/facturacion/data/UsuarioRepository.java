package com.example.facturacion.data;

import com.example.facturacion.logic.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{
    Usuario findByidentificacion(String identificacion);
}
