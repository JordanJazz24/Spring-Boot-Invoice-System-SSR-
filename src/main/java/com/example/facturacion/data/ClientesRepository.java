package com.example.facturacion.data;

import com.example.facturacion.logic.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends CrudRepository<Cliente, String>{
    @Query("SELECT c FROM Cliente c WHERE c.proveedorByIdProveedor.id = ?1")
    Iterable<Cliente> findByproveedorByIdProveedor(int id);

    Cliente findByidentificacion(String identificacion);
    Cliente findByid(int id);
}
