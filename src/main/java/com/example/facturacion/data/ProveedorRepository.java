package com.example.facturacion.data;

import com.example.facturacion.logic.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, String>{

    Proveedor findByUsuario_Identificacion(String identificacion);
}
