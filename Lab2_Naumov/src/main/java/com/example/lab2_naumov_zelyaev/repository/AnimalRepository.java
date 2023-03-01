package com.example.lab2_naumov_zelyaev.repository;

import com.example.lab2_naumov_zelyaev.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
