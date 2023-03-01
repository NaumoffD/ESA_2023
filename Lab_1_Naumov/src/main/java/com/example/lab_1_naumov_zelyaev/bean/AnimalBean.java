package com.example.lab_1_naumov_zelyaev.bean;

import com.example.lab_1_naumov_zelyaev.entity.Animal;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class AnimalBean {
    @PersistenceContext()
    private EntityManager summary;
    //Добавляем информацию о владельце
    public Animal add(Animal animal){
        return summary.merge(animal);
    }
    //Получаем информацию о владельце по Id
    public Animal get(long chipId){
        return summary.find(Animal.class, chipId);
    }
    //Обновляем информацию о владельце
    public void update (Animal animal){
        add(animal);
    }
    //Удаляем информацию о владельце
    public void delete (long chipId){
        summary.remove(get(chipId));
    }
    public List<Animal> getAll(){
        TypedQuery<Animal> animalQuery = summary.createNamedQuery("SummaryOfTheAnimal.getAll" , Animal.class);
        return animalQuery.getResultList();
    }
}
