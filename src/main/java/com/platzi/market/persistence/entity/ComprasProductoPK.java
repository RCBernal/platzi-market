package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

//indicamos que la clase puede ser «integrable» dentro de una entidad
@Embeddable
public class ComprasProductoPK implements Serializable { //Implementamos una interfaz de Java Serializable

    @Column(name = "id_compra")
     private Integer idCompra;

    @Column(name="id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
