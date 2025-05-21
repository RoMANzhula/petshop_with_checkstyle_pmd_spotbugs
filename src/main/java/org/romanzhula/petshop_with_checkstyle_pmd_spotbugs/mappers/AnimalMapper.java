package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.request.AnimalRequest;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.response.AnimalResponse;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "species", target = "species")
    AnimalResponse toResponse(Animal animal);


    @Mapping(source = "name", target = "name")
    @Mapping(source = "species", target = "species")
    Animal toEntity(AnimalRequest animalRequest);

    
    List<AnimalResponse> toResponseList(List<Animal> animals);

}
