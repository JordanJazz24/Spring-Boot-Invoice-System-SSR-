package com.example.facturacion.logic;

import com.example.facturacion.data.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service("Service")
public class Service {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private ProductosRepository productosRepository;
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private DetalleRepository detalleRepository;

    public Iterable<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario usuarioRead(String identificacion) {
        return usuarioRepository.findByidentificacion(identificacion);
    }

    public Proveedor proveedorRead(String identificacion) {
        Usuario usuario = usuarioRepository.findByidentificacion(identificacion);
        if (usuario != null) {
        Proveedor    proveedor= proveedorRepository.findByusuario(usuario);
            return proveedor;
            }

        return new Proveedor( );
    }
    public Proveedor proveedorReadID(int id) {
        return proveedorRepository.findById(id).get();
    }

    public Iterable<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    public void proveedorUpdate(Proveedor proveedorDB) {
        proveedorRepository.save(proveedorDB);
    }
   public void clienteUpdate(Cliente cliente) {
        clientesRepository.save(cliente);
    }

    public Iterable<Cliente> getClientes(int id) {
       Iterable<Cliente> clientes = clientesRepository.findByproveedorByIdProveedor(id);
        return clientes;
    }

    public void createCliente(Cliente cliente) {
        clientesRepository.save(cliente);
    }

    public Cliente clienteRead(String identificacion) {
        Cliente cliente = clientesRepository.findByidentificacion(identificacion);
        return cliente;
    }

    public Cliente clienteReadById(int id) {
        Cliente cliente = clientesRepository.findByid(id);
        return cliente;
    }

    public Iterable<Producto> getProductos(int id) {
        Iterable<Producto> productos = productosRepository.findByproveedorByIdProveedor(id);
        return productos;
    }

    public Producto productoReadById(int id) {
        return productosRepository.findByid(id);
    }

    public void productoUpdate(Producto productoDB) {
        productosRepository.save(productoDB);
    }

    public void createProducto(Producto producto) {
        productosRepository.save(producto);
    }

    public Producto productoRead(String codigo) {
        Producto producto = productosRepository.findBycodigo(codigo);
        return producto;
    }

    public void createProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    public void createUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Iterable<Factura> getFacturas(int id) {
        Iterable<Factura> facturas = facturaRepository.findByproveedorByIdProveedor(id);
        return facturas;
    }

    public Iterable<Detalle> getDetalles() {
        Iterable<Detalle> detalles = detalleRepository.findAll();
        return detalles;
    }

}
