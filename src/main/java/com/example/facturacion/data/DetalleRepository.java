package com.example.facturacion.data;

import com.example.facturacion.logic.Detalle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends CrudRepository<Detalle, String>{

}
