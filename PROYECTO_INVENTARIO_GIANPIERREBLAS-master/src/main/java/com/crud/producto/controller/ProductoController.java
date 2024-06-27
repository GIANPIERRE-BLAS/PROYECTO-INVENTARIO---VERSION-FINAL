package com.crud.producto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.producto.entity.Producto;
import com.crud.producto.service.IProductoService;
import com.crud.categoria.service.ICategoriaService;

@Controller
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/listarProductos")
    public String listProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "productos";
    }

    @GetMapping("/nuevoProducto")
    public String newProducto(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "formProductos";
    }

    @PostMapping("/guardarProducto")
    public String saveProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/listarProductos";
    }

    @GetMapping("/editarProducto/{codigo}")
    public String editProducto(@PathVariable Long codigo, Model model) {
        Producto producto = productoService.buscarProducto(codigo).orElse(null);
        if (producto != null) {
            model.addAttribute("producto", producto);
            model.addAttribute("categorias", categoriaService.listarCategorias());
            return "formProductos";
        } else {
            return "redirect:/listarProductos";
        }
    }

    @PostMapping("/actualizarProducto")
    public String updateProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/listarProductos";
    }

    @GetMapping("/eliminarProducto/{codigo}")
    public String deleteProducto(@PathVariable Long codigo) {
        productoService.eliminarProducto(codigo);
        return "redirect:/listarProductos";
    }
}

