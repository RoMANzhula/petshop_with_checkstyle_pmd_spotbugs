package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AnimalRequest {

    @NotBlank(message = "Name must not be blank.")
    private String name;

    @NotBlank(message = "Species must not be blank.")
    private String species;


    public AnimalRequest() {
    }

    public AnimalRequest(String name, String species) {
        this.name = name;
        this.species = species;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
