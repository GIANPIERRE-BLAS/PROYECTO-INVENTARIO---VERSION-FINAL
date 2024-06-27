package com.crud.proveedor.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.proveedor.modelo.Proveedor;

@Repository
public interface IProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    List<Proveedor> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
}
