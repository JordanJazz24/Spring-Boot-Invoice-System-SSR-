package com.example.facturacion.data;

import com.example.facturacion.logic.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Integer>{
    @Query("SELECT c FROM Factura c WHERE c.proveedorByIdProveedor.id = ?1")
    Iterable<Factura> findByproveedorByIdProveedor(int id);




}
