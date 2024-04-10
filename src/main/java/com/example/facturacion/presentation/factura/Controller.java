package com.example.facturacion.presentation.factura;

import com.example.facturacion.logic.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@org.springframework.stereotype.Controller("FacturaController")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/presentation/factura/show")
    public String showFacturas(Model model, HttpSession session) {
        // Obtener el proveedor de la sesión
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");

        // Buscar las facturas del proveedor
        Iterable<Factura> facturasList = service.getFacturas(proveedor.getId());
    //buscar los detalles de las facturas
        Iterable<Detalle> detallesList = service.getDetalles();

        // Agregar las listas al modelo
        model.addAttribute("facturasList", facturasList);
        model.addAttribute("detalleList", detallesList);

        return "/presentation/factura/View";
    }


}
