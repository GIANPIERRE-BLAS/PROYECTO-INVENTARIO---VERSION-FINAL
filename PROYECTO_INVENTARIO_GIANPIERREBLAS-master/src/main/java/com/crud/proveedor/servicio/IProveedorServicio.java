package com.crud.proveedor.servicio;

import java.util.List;
import java.util.Optional;

import com.crud.proveedor.modelo.Proveedor;

public interface IProveedorServicio {
    List<Proveedor> listarProveedores();
    Proveedor guardarProveedor(Proveedor proveedor);
    Optional<Proveedor> obtenerProveedorPorId(Long id);
    void eliminarProveedor(Long id);
    List<Proveedor> buscarProveedores(String keyword);
}
