package com.crud.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.producto.entity.Producto;
import com.crud.producto.repository.IProductoRepository;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private IProductoRepository repositorio;

    @Override
    public List<Producto> listarProductos() {
        return repositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Optional<Producto> buscarProducto(Long codigo) {
        return repositorio.findById(codigo);
    }

    @Override
    public void eliminarProducto(Long codigo) {
        repositorio.deleteById(codigo);
    }
}
