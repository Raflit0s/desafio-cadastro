package entity;

import petEnum.Sex;
import util.Address;

public class Pet {

    private String name;
    private String lastName;
    private String type;
    private Sex sex;
    private Double age;
    private Double weight;
    private String race;
    private Address address;

    public Pet() {
    }

    public Pet(String name, String lastName, String type, String sex, Double age, Double weight, String race, Address address) {
        this.name = name;
        this.type = type;
        this.lastName = lastName;
        this.sex = Sex.valueOf(sex);
        this.age = age;
        this.weight = weight;
        this.race = race;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = Sex.valueOf(sex);
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
