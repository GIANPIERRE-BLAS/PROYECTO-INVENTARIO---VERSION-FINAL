package com.crud.categoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.categoria.entity.Categoria;
import com.crud.categoria.service.ICategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/listarCategorias")
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", categoriaService.listarCategorias());
        return "categorias";
    }

    @GetMapping("/nuevaCategoria")
    public String nuevaCategoria(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "formCategorias";
    }

    @PostMapping("/guardarCategoria")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/listarCategorias";
    }

    @GetMapping("/editarCategoria/{id}")
    public String editarCategoria(@PathVariable Long id, Model modelo) {
        Categoria categoria = categoriaService.buscarCategoria(id).orElse(null);
        if (categoria != null) {
            modelo.addAttribute("categoria", categoria);
            return "formCategorias";
        } else {
            return "error";
        }
    }

    @GetMapping("/eliminarCategoria/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/listarCategorias";
    }
}



