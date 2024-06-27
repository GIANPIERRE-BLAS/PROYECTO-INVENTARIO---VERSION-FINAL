package com.crud.categoria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tbl_Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categ")
    private Long codCategoria;

    @Column(name = "des_categ")
    private String desCategoria;

    public Categoria() {
    }

    public Categoria(Long codCategoria, String desCategoria) {
        this.codCategoria = codCategoria;
        this.desCategoria = desCategoria;
    }

    public Categoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    public Long getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Long codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    @Override
    public String toString() {
        return desCategoria;
    }
}

