package com.crud.producto.entity;

import com.crud.categoria.entity.Categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tbl_Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_prod")
    private Long codProducto;

    @Column(name = "des_prod")
    private String desProducto;

    @ManyToOne
    @JoinColumn(name = "cod_categ")
    private Categoria categoria;

    public Producto() {
    }

    public Producto(Long codProducto, String desProducto, Categoria categoria) {
        this.codProducto = codProducto;
        this.desProducto = desProducto;
        this.categoria = categoria;
    }

    public Producto(String desProducto, Categoria categoria) {
        this.desProducto = desProducto;
        this.categoria = categoria;
    }

    // Getters y Setters

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
