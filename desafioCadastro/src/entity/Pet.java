package entity;

import petEnum.PetSex;
import petEnum.PetType;

public class Pet {

    public static final String NOT_INFORMED = "NÃO INFORMADO";
    private String name;
    private String lastName;
    private PetType type;
    private PetSex sex;
    private Object age;
    private Object weight;
    private String race;
    private Address address;

    public Pet() {
    }

    public Pet(String name, String lastName, String type, String sex, Object age, Object weight, String race, Address address) {
        this.name = name;
        this.type = PetType.valueOf(type);
        this.lastName = lastName;
        this.sex = PetSex.valueOf(sex);
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

    public PetType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = PetType.valueOf(type);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PetSex getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = PetSex.valueOf(sex);
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
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

    //se nome e sobrenome não forem fornecidos ou possuírem caracteres especiais, lança uma exceção.
    public void validateName(String name, String lastName) {
        StringBuilder nomeCompleto = new StringBuilder(name).append(lastName);

        if(name.trim().isEmpty() || lastName.trim().isEmpty()) {
            throw new RuntimeException("Nome e sobrenome são necessários.");
        }else if(!nomeCompleto.toString().matches("[a-zA-Z ]+")) {
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

        //verifica se os atributos são instância de double, se forem, adiciona valor + anos ou kg, se não, imprime apenas "NÃO INFORMADO".
        String ageStr = (age instanceof Double) ? age + " anos\n" : age.toString() + "\n";
        String weightStr = (weight instanceof Double) ? weight + "kg\n" : weight.toString()+ "\n";

        return "1 - " + name + " " + lastName + "\n"
                + "2 - " + type + "\n"
                + "3 - " + sex + "\n"
                + "4 - " + address + "\n"
                + "5 - " + ageStr
                + "6 - " + weightStr
                + "7 - " + race;
    }
}
