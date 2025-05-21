package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.controllers;

import jakarta.validation.Valid;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.request.AnimalRequest;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.response.AnimalResponse;
import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.services.AnimalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/animals")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping
    public ResponseEntity<List<AnimalResponse>> getAllAnimals() {
        return ResponseEntity.ok(animalService.getAllAnimals());
    }


    @GetMapping("/id")
    public ResponseEntity<AnimalResponse> getAnimalById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(animalService.getById(id));
    }


    @GetMapping("/search")
    public ResponseEntity<List<AnimalResponse>> getAnimalByName(
            @RequestParam String name
    ) {
        return ResponseEntity.ok(animalService.getByName(name));
    }


    @PostMapping("/new")
    public ResponseEntity<AnimalResponse> addAnimal(
            @RequestBody @Valid AnimalRequest animalRequest
    ) {
        return ResponseEntity.ok(animalService.saveNewAnimal(animalRequest));
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<AnimalResponse> updateAnimal(
            @PathVariable Long id,
            @RequestBody @Valid AnimalRequest updatedAnimalRequest
    ) {
        return ResponseEntity.ok(animalService.updateAnimal(id, updatedAnimalRequest));
    }

    
    @DeleteMapping("/clear/{id}")
    public ResponseEntity<Void> goodLifeAnimal(
            @PathVariable Long id
    ) {
        animalService.clearPositionById(id);
        return ResponseEntity.noContent().build(); // 204 no content
    }

}
