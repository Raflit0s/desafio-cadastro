package entity;

public class Pet {

    private String name;
    private String lastName;
    private String sex;
    private Integer age;
    private Double weight;
    private String race;
    private String Address;

    public Pet() {
    }

    public Pet(String name, String lastName, String sex, Integer age, Double weight, String race, String address) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.race = race;
        Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
