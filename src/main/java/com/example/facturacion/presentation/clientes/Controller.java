package com.example.facturacion.presentation.clientes;

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

@org.springframework.stereotype.Controller("ClientesController")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/presentation/clientes/show")
    public String showUsuarios(Model model, HttpSession session) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        model.addAttribute("clientesList", service.getClientes(proveedor.getId()));
        model.addAttribute("clienteEdit", new Cliente());
        return "/presentation/clientes/View";
    }

    @PostMapping("/presentation/clientes/create")
    public String createCliente(@ModelAttribute("clienteEdit") Cliente cliente, HttpSession session) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        //verificar si el cliente ya existe en la base de datos
        Cliente clienteDB = service.clienteReadById(cliente.getId());
        if (clienteDB != null) {//si el cliente ya existe
            //actualizar el cliente
            clienteDB.setIdentificacion(cliente.getIdentificacion());
            clienteDB.setNombre(cliente.getNombre());
            clienteDB.setCorreo(cliente.getCorreo());
            clienteDB.setTelefono(cliente.getTelefono());

            service.clienteUpdate(clienteDB);
        } else {

            cliente.setProveedorByIdProveedor(proveedor);
            service.createCliente(cliente);
        }
        return "redirect:/presentation/clientes/show";
    }

    @PostMapping("/presentation/clientes/consultar")
    public String consultarCliente(@ModelAttribute("clienteEdit") Cliente cliente,
                                   Model model) {
        if (cliente.getIdentificacion().isEmpty()) {
            return "redirect:/presentation/clientes/show";
        }
        Cliente clienteDB = service.clienteRead(cliente.getIdentificacion());
        model.addAttribute("clientesList", clienteDB);
        model.addAttribute("clienteEdit", new Cliente());
        return "/presentation/clientes/View";
    }


    @GetMapping("/presentation/clientes/edit/")
    public String editCliente(@ModelAttribute("clienteEdit") Cliente cliente, HttpSession session, Model model) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        Cliente clienteDB = service.clienteRead(cliente.getIdentificacion());
        if (clienteDB == null) {
            return "redirect:/presentation/clientes/show";
        }
        model.addAttribute("clienteEdit", clienteDB);
        model.addAttribute("clientesList", service.getClientes(proveedor.getId()));
        return "/presentation/clientes/View";
    }


}
