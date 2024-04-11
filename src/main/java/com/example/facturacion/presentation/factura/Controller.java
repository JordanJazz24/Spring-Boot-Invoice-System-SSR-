        package com.example.facturacion.presentation.factura;

        import com.example.facturacion.logic.*;
        import jakarta.servlet.http.HttpSession;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;

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

            @GetMapping("/presentation/facturacion/show")
            public String showFacturacion(Model model, HttpSession session) {
                // Obtener el proveedor de la sesión
                Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
                model.addAttribute("proveedor", proveedor);
                model.addAttribute("cliente", new Cliente());
                Iterable<Producto> productosList =service.getProductos(proveedor.getId());
                model.addAttribute( "productosList", productosList);
                return "/presentation/facturacion/View";
            }

            @PostMapping("/presentation/facturacion/validar")
            public String validarCliente(@ModelAttribute Cliente cliente,HttpSession session, Model model) {

                Cliente clienteDB = service.clienteRead(cliente.getIdentificacion());
                if (clienteDB == null) {
                    return "/presentation/facturacion/show";
                }
                model.addAttribute("cliente", clienteDB);
                Proveedor proveedor = (Proveedor) session.getAttribute("proveedor");
                model.addAttribute("proveedor", proveedor);

                return "/presentation/facturacion/View";
            }

        }
