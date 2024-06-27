package com.crud.producto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.producto.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findByDesProductoContaining(String desProducto);
    
    @Query("SELECT p FROM Producto p WHERE p.categoria.codCategoria = :codCategoria")
    List<Producto> findByCategoria(@Param("codCategoria") Long codCategoria);
    
    
}

