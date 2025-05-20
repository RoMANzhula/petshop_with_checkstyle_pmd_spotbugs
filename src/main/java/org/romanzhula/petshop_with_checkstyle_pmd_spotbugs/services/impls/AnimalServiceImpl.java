package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services.impls;

import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.exception_handlers.exceptions.ResourceNotFoundException;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.repositories.AnimalRepository;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Animal with ID " + id + " not found."
                ))
        ;
    }

    @Override
    public List<Animal> getByName(String name) {
        return animalRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Animal saveNewAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateAnimal(Long id, Animal updatedAnimal) {
        Animal existingAnimal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Animal with ID " + id + " not found."
                ))
        ;

        existingAnimal.setName(updatedAnimal.getName());
        existingAnimal.setSpecies(updatedAnimal.getSpecies());

        return animalRepository.save(existingAnimal);
    }

}
