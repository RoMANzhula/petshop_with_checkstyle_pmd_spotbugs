package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services.impls;

import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.request.AnimalRequest;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.response.AnimalResponse;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.exception_handlers.exceptions.ResourceNotFoundException;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.mappers.AnimalMapper;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.repositories.AnimalRepository;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;


    public AnimalServiceImpl(AnimalRepository animalRepository, AnimalMapper animalMapper) {
        this.animalRepository = animalRepository;
        this.animalMapper = animalMapper;
    }


    @Override
    public List<AnimalResponse> getAllAnimals() {
        return animalMapper.toResponseList(animalRepository.findAll());
    }

    @Override
    public AnimalResponse getById(Long id) {
        return animalMapper.toResponse(animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Animal with ID " + id + " not found."
                ))
        );
    }

    @Override
    public List<AnimalResponse> getByName(String name) {
        return animalMapper.toResponseList(animalRepository.findByNameIgnoreCase(name));
    }

    @Override
    public AnimalResponse saveNewAnimal(AnimalRequest animalRequest) {
        return animalMapper.toResponse(animalRepository.save(animalMapper.toEntity(animalRequest)));
    }

    @Override
    public AnimalResponse updateAnimal(Long id, AnimalRequest updatedAnimalRequest) {
        Animal existingAnimal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Animal with ID " + id + " not found."
                ))
        ;

        existingAnimal.setName(updatedAnimalRequest.getName());
        existingAnimal.setSpecies(updatedAnimalRequest.getSpecies());

        Animal savedAnimal = animalRepository.save(existingAnimal);

        return animalMapper.toResponse(savedAnimal);
    }

    @Override
    public void clearPositionById(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new ResourceNotFoundException("Animal with ID " + id + " not found.");
        }

        animalRepository.deleteById(id);
    }

}
