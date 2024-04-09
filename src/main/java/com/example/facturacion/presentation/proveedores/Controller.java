package com.example.facturacion.presentation.proveedores;

import com.example.facturacion.logic.Proveedor;
import com.example.facturacion.logic.Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller("ProveedoresController")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping ("/presentation/proveedores/show")
    public String showUsuarios(Model model, HttpSession session) {
        model.addAttribute("listaProveedores", service.getProveedores());
        return "/presentation/proveedores/View";
    }

}
