package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//Insicamos que es un componente de tipo Spring
@Mapper(componentModel = "Spring")
public interface CategoryMapper {
    //Se procede a dise;ar los conversores con los mapper

    // Este va a retornar la categoria
    @Mappings({
            @Mapping(source="idCategoria",target="categoryId"),
            @Mapping(source="descripcion",target="category"),
            @Mapping(source="estado",target="active")
    })
    Category toCategory(Categoria categoria);

    //Vamos a realizar una conversion externa , ahora vamos a convertir una Category a Categoria
    //@InheritInverseConfiguration le inidca a MappStruct que vamos a realizar una conversion inversa de lo que
    // teenmos arriba y no tenemos que definir de nuevo los mappings
    @InheritInverseConfiguration
    @Mapping(target = "productos",ignore = true)
    Categoria toCategoria(Category category);
}
