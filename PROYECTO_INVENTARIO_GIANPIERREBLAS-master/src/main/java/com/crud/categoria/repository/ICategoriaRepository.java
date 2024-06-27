package com.crud.categoria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.categoria.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByDesCategoriaContaining(String desCategoria);
}
