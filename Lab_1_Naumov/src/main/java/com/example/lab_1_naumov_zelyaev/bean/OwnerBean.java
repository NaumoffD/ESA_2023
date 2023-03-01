package com.example.lab_1_naumov_zelyaev.bean;

import com.example.lab_1_naumov_zelyaev.entity.Owner;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class OwnerBean {

    @PersistenceContext()
    private EntityManager animalOwnerInfo;
    //Добавляем информацию о владельце
    public Owner add(Owner owner){
        return animalOwnerInfo.merge(owner);
    }
    //Получаем информацию о владельце по Id
    public Owner get(long animalOwnerId){

        return animalOwnerInfo.find(Owner.class, animalOwnerId);
    }
    //Обновляем информацию о владельце
    public void update (Owner owner){
        add(owner);
    }
    //Удаляем информацию о владельце
    public void delete (long animalOwnerId){
        animalOwnerInfo.remove(get(animalOwnerId));
    }
    public List<Owner> getAll(){
        TypedQuery<Owner> ownerQuery = animalOwnerInfo.createNamedQuery("AnimalOwnerInformation.getAll", Owner.class);
        return ownerQuery.getResultList();
    }
    public String getOwner(Long animalOwnerId){
        if (animalOwnerId == null)
            return "Владелец отсуствует";
        Owner owner = get(animalOwnerId);
        return owner.getFirstName() + " " + owner.getSurname() + " " + owner.getPatronymic();
    }

}
