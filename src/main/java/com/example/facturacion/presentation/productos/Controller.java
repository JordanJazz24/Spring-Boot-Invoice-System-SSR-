package com.example.facturacion.presentation.productos;

import com.example.facturacion.logic.Producto;
import com.example.facturacion.logic.Proveedor;
import com.example.facturacion.logic.Service;
import com.example.facturacion.logic.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller("ProductoController")
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/presentation/productos/show")
    public String show(Model model, HttpSession session) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        model.addAttribute("productosList", service.getProductos(proveedor.getId()));
        model.addAttribute("productoEdit", new Producto());
        return "/presentation/productos/View";
    }

    @PostMapping("/presentation/productos/create")
    public String createProducto(@ModelAttribute("productoEdit") Producto producto, HttpSession session) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        //verificar si el productos ya existe en la base de datos
        Producto productoDB = service.productoReadById(producto.getId());
        if (productoDB != null) {//si el producto ya existe
            //actualizar el producto
            productoDB.setCodigo(producto.getCodigo());
            productoDB.setNombre(producto.getNombre());
            productoDB.setDescripcion(producto.getDescripcion());
            productoDB.setPrecio(producto.getPrecio());

            service.productoUpdate(productoDB);
        } else {

            producto.setProveedorByIdProveedor(proveedor);
            service.createProducto(producto);
        }
        return "redirect:/presentation/productos/show";
    }

    @PostMapping("/presentation/productos/consultar")
    public String consultarProducto(@ModelAttribute("productoEdit") Producto producto,
                                    HttpSession session,
                                    Model model) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        if (producto.getCodigo().isEmpty()) {
            return "redirect:/presentation/productos/show";
        }
        Producto productoDB = service.productoRead(producto.getCodigo());
        model.addAttribute("productosList", productoDB);
        model.addAttribute("productoEdit", new Producto());
        return "/presentation/productos/View";
    }


    @GetMapping("/presentation/productos/edit/")
    public String editProducto(@ModelAttribute("productoEdit") Producto producto, HttpSession session, Model model) {
        Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
        Producto productoDB = service.productoRead(producto.getCodigo());
        if (productoDB == null) {
            return "redirect:/presentation/productos/show";
        }
        model.addAttribute("productoEdit", productoDB);
        model.addAttribute("productosList", service.getProductos(proveedor.getId()));
        return "/presentation/productos/View";
    }


}
