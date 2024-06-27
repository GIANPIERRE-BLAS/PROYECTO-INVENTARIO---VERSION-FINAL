package com.crud.categoria.service;

import java.util.List;
import java.util.Optional;

import com.crud.categoria.entity.Categoria;

public interface ICategoriaService {
    List<Categoria> listarCategorias();
    Categoria guardarCategoria(Categoria categoria);
    Optional<Categoria> buscarCategoria(Long codigo);
    void eliminarCategoria(Long codigo);
}
