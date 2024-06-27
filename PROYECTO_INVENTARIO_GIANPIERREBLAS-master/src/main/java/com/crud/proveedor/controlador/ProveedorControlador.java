package com.crud.proveedor.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.proveedor.modelo.Proveedor;
import com.crud.proveedor.servicio.IProveedorServicio;

@Controller
@RequestMapping("/proveedores")
public class ProveedorControlador {

    @Autowired
    private IProveedorServicio proveedorServicio;

    @GetMapping 
    public List<Proveedor> listarProveedores (){
        return proveedorServicio.listarProveedores();
    }

    @GetMapping("/lista")
    public String verTodosLosProveedores(Model modelo, @RequestParam(value = "keyword", required = false) String keyword) {
        List<Proveedor> proveedores;
        if (keyword != null && !keyword.isEmpty()) {
            proveedores = proveedorServicio.buscarProveedores(keyword);
        } else {
            proveedores = proveedorServicio.listarProveedores();
        }
        modelo.addAttribute("proveedores", proveedores);
        modelo.addAttribute("keyword", keyword);
        return "proveedores";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoProveedor(Model modelo) {
        modelo.addAttribute("proveedor", new Proveedor());
        return "formProveedor";
    }

    @PostMapping("/guardar")
    public String guardarNuevoProveedor(@ModelAttribute("proveedor") Proveedor proveedor) {
        proveedorServicio.guardarProveedor(proveedor);
        return "redirect:/proveedores/lista";
    }

    @GetMapping("/editar")
    public String mostrarFormularioEditarProveedor(@RequestParam("id") Long id, Model modelo) {
        Optional<Proveedor> proveedor = proveedorServicio.obtenerProveedorPorId(id);
        if (proveedor.isPresent()) {
            modelo.addAttribute("proveedor", proveedor.get());
            return "formProveedor";
        } else {
            return "error"; // Página de error si el proveedor no se encuentra
        }
    }

    @GetMapping("/eliminar")
    public String eliminarProveedor(@RequestParam("id") Long id) {
        proveedorServicio.eliminarProveedor(id);
        return "redirect:/proveedores/lista";
    }
}

