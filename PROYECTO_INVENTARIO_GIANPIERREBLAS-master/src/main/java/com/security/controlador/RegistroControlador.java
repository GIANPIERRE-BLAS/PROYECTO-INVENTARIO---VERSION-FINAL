package com.security.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.crud.proveedor.servicio.IProveedorServicio;
import com.crud.categoria.service.ICategoriaService;
import com.crud.producto.service.IProductoService;

@Controller
public class RegistroControlador {

    @Autowired
    private IProveedorServicio servicioProveedor;

    @Autowired
    private ICategoriaService categoriaServicio;

    @Autowired
    private IProductoService productoServicio;

    @GetMapping("/index")
    public String index() {
        return "index"; // Redirige al index
    }

    @GetMapping("/login")
    public String iniciarSesion() {
        return "login"; // Luego redirige al login
    }
 
    @GetMapping("/bienvenida")
    public String bienvenida() {
        return "bienvenida"; // Redirige a la página de bienvenida después del login
    }

    @GetMapping("/Inventario")
    public String inventario() {
        return "Inventario"; // Redirige a la página despues de la buennevidad
        }

    @GetMapping("/proveedores/vista")
    public String verProveedores(Model modelo) {
        modelo.addAttribute("proveedores", servicioProveedor.listarProveedores());
        return "proveedores"; // Devuelve la vista de proveedores
    }
    
    @GetMapping("/productos")
    public String mostrarProductos(Model modelo) {
        modelo.addAttribute("productos", productoServicio.listarProductos());
        return "productos"; 
    }

    @GetMapping("/categorias")
    public String mostrarCategorias(Model modelo) {
        modelo.addAttribute("categorias", categoriaServicio.listarCategorias());
        return "categorias"; 
    }
    
    @GetMapping("/mostrarCategorias") 
    public String mostrarCategoriasOtraRuta(Model modelo) {
        modelo.addAttribute("categorias", categoriaServicio.listarCategorias());
        return "categorias"; 
    }
    
    @GetMapping("/mostrarProductos") 
    public String mostrarProductosOtraRuta(Model modelo) {
        modelo.addAttribute("productos", productoServicio.listarProductos());
        return "productos"; 
    }
}

 
