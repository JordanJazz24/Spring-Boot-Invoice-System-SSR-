package com.example.facturacion.data;

import com.example.facturacion.logic.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends CrudRepository<Producto, String>{
    @Query("SELECT c FROM Producto c WHERE c.proveedorByIdProveedor.id = ?1")
    Iterable<Producto> findByproveedorByIdProveedor(int id);

    Producto findByid(int id);

    Producto findBycodigo(String codigo);
}
