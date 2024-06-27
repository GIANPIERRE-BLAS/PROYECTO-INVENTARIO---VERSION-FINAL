package com.crud.proveedor.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.proveedor.modelo.Proveedor;
import com.crud.proveedor.repositorio.IProveedorRepositorio;

@Service
public class ProveedorServicioImpl implements IProveedorServicio {

    @Autowired
    private IProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        return proveedorRepositorio.findById(id);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepositorio.deleteById(id);
    }

    @Override
    public List<Proveedor> buscarProveedores(String keyword) {
        return proveedorRepositorio.findByNombreContainingOrApellidoContaining(keyword, keyword);
    }
}



