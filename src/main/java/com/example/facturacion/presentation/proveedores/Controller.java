package com.example.facturacion.presentation.proveedores;

import com.example.facturacion.logic.Cliente;
import com.example.facturacion.logic.Proveedor;
import com.example.facturacion.logic.Service;
import com.example.facturacion.logic.Usuario;
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
         switch (proveedorDB.getEstado()){
             case "activo":
                 proveedorDB.setEstado("inactivo");
                 break;
             case "inactivo":
                 proveedorDB.setEstado("activo");
                 break;}
            service.proveedorUpdate(proveedorDB);
            return "redirect:/presentation/proveedores/show";
        } catch (Exception e) {
            return "/";
        }
    }

    @GetMapping("/presentation/proveedores/registro/show")
    public String registrarProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("usuario", new Usuario());
        return "/presentation/registro/View";
    }

    @PostMapping("/presentation/proveedores/registrar")
    public String registrarProveedor(@ModelAttribute("proveedor") Proveedor proveedor, @ModelAttribute("usuario") Usuario usuario) {
        try {
            //primero se dbe crear el usuario en la base de datos
            service.createUsuario(usuario);
            //se obtiene el usuario creado
            Usuario usuarioDB = service.usuarioRead(usuario.getIdentificacion());
            //se asigna el usuario al proveedor
            proveedor.setUsuario(usuarioDB);
            //se crea el proveedor
            service.createProveedor(proveedor);
            return "redirect:/";
        } catch (Exception e) {
            return "/";
        }

    }

}
