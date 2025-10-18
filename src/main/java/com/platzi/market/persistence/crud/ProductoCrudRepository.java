package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*
    Se puede implementar un Query nativo si necesitamos remplazar los QueryMethods
    @Query(value = "SELECT * FROM productos WHERE id_categoria=?", nativeQuery = true)
    */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

//    Los Query Metods soportan los operadores opcionales de las neuvas versiones de java
//    Vamos a recuperar una lista de producto con cantidad stock y etado
    Optional<List<Producto>>findAllByCantidadStockLeesThanAndEstado(int cantidadStock, boolean estado);
}
