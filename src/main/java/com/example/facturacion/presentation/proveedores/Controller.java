package com.example.facturacion.presentation.proveedores;

import com.example.facturacion.logic.Proveedor;
import com.example.facturacion.logic.Service;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller("ProveedoresController")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping ("/presentation/proveedores/show")
    public String showUsuarios(Model model, HttpSession session) {
        model.addAttribute("listaProveedores", service.getProveedores());
        return "/presentation/proveedores/View";
    }

    @GetMapping("/presentation/proveedores/activar")
    public String activarProveedor(@ModelAttribute("Proveedor") Proveedor proveedor, HttpSession httpSession) {
        try {
            Proveedor proveedorDB = service.proveedorReadID(proveedor.getId());
            proveedorDB.setEstado("activo");
            service.proveedorUpdate(proveedorDB);
            return "redirect:/presentation/proveedores/show";
        } catch (Exception e) {
            return "/";
        }
    }
}
