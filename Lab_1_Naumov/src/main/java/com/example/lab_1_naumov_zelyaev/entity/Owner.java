package com.example.lab_1_naumov_zelyaev.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "owner")
@Table(name = "animal_owner_information")
@NamedQuery(name = "AnimalOwnerInformation.getAll", query = "SELECT a from owner a")
public class Owner {


    @OneToMany (fetch = FetchType.EAGER)
    @JoinColumn(name = "id_owner", nullable = true) // we need to duplicate the physical information
    private List<Animal> animals;

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_owner_id")
    private long ownerId;

    public List<Animal> getAnimals() {
        return animals;
    }
    public void addAnimal(Animal animal){
        animals.add(animal);
        animal.setOwner(this);
        animal.setIdOwner(this.getOwnerId());
    }
    public void removeAnimal(Animal animal){
        animals.remove(animal);
        animal.setOwner(null);
        animal.setIdOwner(null);
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    public Owner(){

    }

    public Owner(String firstName, String surname, String patronymic, String phoneNumber, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getFullName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(surname);
        stringBuilder.append(" ");
        stringBuilder.append(patronymic);
        return stringBuilder.toString();
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ФИО: ");
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(surname);
        stringBuilder.append(" ");
        stringBuilder.append(patronymic);
        stringBuilder.append(" | Телефон: ");
        stringBuilder.append(phoneNumber);
        stringBuilder.append(" | Адрес: ");
        stringBuilder.append(address);
        return stringBuilder.toString();
    }
}
