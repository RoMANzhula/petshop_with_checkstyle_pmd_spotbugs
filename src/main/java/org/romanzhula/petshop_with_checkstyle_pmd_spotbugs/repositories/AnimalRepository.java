package org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.repositories;

import org.romanzhula.petshop_with_checkstyle_pmd_spotbugs.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
