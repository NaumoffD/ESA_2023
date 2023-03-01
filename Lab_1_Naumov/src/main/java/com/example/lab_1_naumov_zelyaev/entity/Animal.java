package com.example.lab_1_naumov_zelyaev.entity;


import jakarta.persistence.*;

@Entity(name = "animal")
@Table(name = "summary_of_the_animal")
@NamedQuery(name = "SummaryOfTheAnimal.getAll", query = "SELECT s from animal s")

public class Animal {

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        if (owner != null){
            this.owner = owner;
            this.id_owner = owner.getOwnerId();
        }
        else{
            this.id_owner = null;
            this.owner= null;
        }

    }

    @ManyToOne
    @JoinColumn(name = "id_owner", insertable = false, updatable = false, nullable = true)
    private Owner owner;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chip_id")
    private long chipId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "breed", nullable = false)
    private String breed;

    @Column(name = "id_owner", nullable = true)
    private Long id_owner;

    public Long getId_owner() {
       return this.id_owner;
    }

    public void setIdOwner(Long id_owner) {
        this.id_owner = id_owner;
    }

    public Animal(){

    }

    public Animal(long chipId) {
        this.chipId = chipId;
    }

    public long getChipId() {
        return chipId;
    }

    public void setChipId(long chipId) {
        this.chipId = chipId;
    }

    public Animal(String name, String sex, String color, String breed, Owner owner) {

        this.name = name;
        this.sex = sex;
        this.color = color;
        this.breed = breed;
        if (owner != null)
            owner.addAnimal(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getStringAnimal() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Кличка: ");
        stringBuilder.append(name);
        stringBuilder.append(" | Пол: ");
        stringBuilder.append(sex);
        stringBuilder.append(" | Окрас: ");
        stringBuilder.append(color);
        stringBuilder.append(" | Порода: ");
        stringBuilder.append(breed);
        return stringBuilder.toString();
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Кличка: ");
        stringBuilder.append(name);
        stringBuilder.append(" | Пол: ");
        stringBuilder.append(sex);
        stringBuilder.append(" | Окрас: ");
        stringBuilder.append(color);
        stringBuilder.append(" | Порода: ");
        stringBuilder.append(breed);
        stringBuilder.append(" | Хозяин: ");
        stringBuilder.append(owner != null ? owner.getFullName() : "отсутствует");
        return stringBuilder.toString();
    }
}
