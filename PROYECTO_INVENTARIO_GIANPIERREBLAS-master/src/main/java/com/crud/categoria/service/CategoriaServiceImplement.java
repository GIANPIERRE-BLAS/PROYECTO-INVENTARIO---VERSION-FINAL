package com.crud.categoria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.categoria.entity.Categoria;
import com.crud.categoria.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImplement implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> buscarCategoria(Long codigo) {
        return categoriaRepository.findById(codigo);
    }

    @Override
    public void eliminarCategoria(Long codigo) {
        categoriaRepository.deleteById(codigo);
    }
}

