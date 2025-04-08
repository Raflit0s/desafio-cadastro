package entity;

import petEnum.Sex;
import petEnum.Type;
import util.Address;

public class Pet {

    public static final String NOT_INFORMED = "NÃO INFORMADO";
    private String name;
    private String lastName;
    private Type type;
    private Sex sex;
    private Object age;
    private Object weight;
    private String race;
    private Address address;

    public Pet() {
    }

    public Pet(String name, String lastName, String type, String sex, Object age, Object weight, String race, Address address) {
        this.name = name;
        this.type = Type.valueOf(type);
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

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Type.valueOf(type);
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

    public Object getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Object getWeight() {
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

    public void validateName(String name, String lastName) {
        StringBuilder sb = new StringBuilder(name).append(lastName);

        if(name.isEmpty() || lastName.isEmpty()) {
            throw new RuntimeException("Nome e sobrenome são necessários.");
        }else if(!sb.toString().matches("[a-zA-Z ]+")) {
            throw new RuntimeException("Nome completo não pode conter caracteres especiais.");
        }

    }

    public void validateWeight(Double weight) {
        if(weight > 60.0 || weight < 0.5) {
            throw new RuntimeException("Insira um peso válido.");
        }
    }

    public void validateAge(Double age) {
        if(age > 20.0) {
            throw new RuntimeException("insira uma idade válida");
        }
    }

    public void validateRace(String race) {
        if(!race.matches("[a-zA-Z ]+")) {
            throw new RuntimeException("Nome da raça não pode conter caracteres especiais.");
        }
    }

    public Double commaToPeriod(String input) {
        String x = input.replace(",", ".");
        return Double.parseDouble(x);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", type='" + type + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", weight=" + weight +
                ", race='" + race + '\'' +
                ", address=" + address +
                '}';
    }
}
