package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models;

import jakarta.persistence.*;


@Entity
@Table(name = "pets")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String species;


    public Animal() {}

    public Animal(Long id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
