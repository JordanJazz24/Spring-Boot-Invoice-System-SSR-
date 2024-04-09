package com.example.facturacion.data;

import com.example.facturacion.logic.Proveedor;
import com.example.facturacion.logic.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Integer>{



    Proveedor findByusuario(Usuario id);
}
