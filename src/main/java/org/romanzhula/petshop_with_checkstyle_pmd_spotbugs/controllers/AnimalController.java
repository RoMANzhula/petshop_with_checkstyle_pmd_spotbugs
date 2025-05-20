package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.controllers;

import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }

    @GetMapping("/id")
    public ResponseEntity<Animal> getAnimalById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(animalService.getById(id));
    }

}
