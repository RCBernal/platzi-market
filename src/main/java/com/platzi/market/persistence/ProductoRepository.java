package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//con @Repository le estamos indicando que esta clase se va a encargar de interactuar con la base de datos
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;



    //Este metodo nos ayuda a traer todos los datos de producto en una lista
    @Override
    public List<Product> getAll() {
        List<Producto>  productos =(List<Producto>) productoCrudRepository.findAll();
        return  mapper.toProducts(productos);
        //return (List<Producto>) productoCrudRepository.findAll();
    }

    // Vamos a devolver la categoria
    @Override
    public Optional<List<Product>> getByCategory(int idCategoria) {
        List<Producto> productos=productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
        return Optional.of(mapper.toProducts(productos));
    }

     // Vamos a crear un metodo publico que retorne un optional de una lista este trae los productos escasos
     @Override
     public Optional<List<Product>> getScarseProducts(int quantity) {
         Optional <List<Producto>> productos =productoCrudRepository.findAllByCantidadStockLeesThanAndEstado(quantity, true);
         return productos.map(mapper::toProducts);
     }

    //Vamos a consultar un solo producto
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    //creamos un metodo para guardar un producto
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //Vamos a crear un metodo para eliminar un producto
    @Override
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
