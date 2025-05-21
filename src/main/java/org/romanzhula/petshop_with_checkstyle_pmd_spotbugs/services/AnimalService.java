package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services;

import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.request.AnimalRequest;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.response.AnimalResponse;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;

import java.util.List;


public interface AnimalService {

    List<AnimalResponse> getAllAnimals();

    AnimalResponse getById(Long id);

    List<AnimalResponse> getByName(String name);

    AnimalResponse saveNewAnimal(AnimalRequest animalRequest);

    AnimalResponse updateAnimal(Long id, AnimalRequest updatedAnimal);

    void clearPositionById(Long id);

}
