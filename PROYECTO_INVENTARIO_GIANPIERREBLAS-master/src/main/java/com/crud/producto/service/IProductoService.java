package com.crud.producto.service;

import java.util.List;
import java.util.Optional;

import com.crud.producto.entity.Producto;

public interface IProductoService {
    List<Producto> listarProductos();
    Producto guardarProducto(Producto producto);
    Optional<Producto> buscarProducto(Long codigo);
    void eliminarProducto(Long codigo);
}
