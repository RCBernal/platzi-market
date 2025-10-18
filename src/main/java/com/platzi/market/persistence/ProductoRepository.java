package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//con @Repository le estamos indicando que esta clase se va a encargar de interactuar con la base de datos
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //Este metodo nos ayuda a traer todos los datos de producto en una lista
    public List<Producto> gertll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }
    // Vamos a devolver la categoria
    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    // Vamos a crear un metodo publico que retorne un optional de una lista
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findAllByCantidadStockLeesThanAndEstado(cantidad, true);
    }

    //Vamos a consultar un solo producto
    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    //creamos un metodo para guardar un producto
    public Producto save(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    //Vamos a crear un metodo para eliminar un producto
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
