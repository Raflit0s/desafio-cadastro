package service;

import entity.Pet;
import util.Address;

import java.util.Scanner;

public class PetService {

    private Pet pet = new Pet();

    public void registration() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o nome do seu pet?");
        String name = sc.nextLine();

        System.out.println("Qual o sobrenome do seu pet?");
        String lastName = sc.nextLine();

        pet.validateName(name, lastName);

        System.out.print("Qual o tipo do pet (Cachorro/Gato?) ");
        String type = sc.nextLine();

        System.out.print("Qual o sexo do animal? ");
        String sex = sc.nextLine();

        System.out.print("Número da casa: ");
        String houseNumberInput = sc.nextLine();
        Object houseNumber = ((houseNumberInput).matches("")) ? Pet.NOT_INFORMED : Integer.parseInt(houseNumberInput);

        System.out.print("Cidade: ");
        String city = sc.nextLine();

        System.out.print("Rua: ");
        String street = sc.nextLine();

        Address address = new Address(houseNumber, city, street);

        System.out.print("Qual a idade aproximada do pet? (em anos)");
        String ageInput = sc.nextLine();

        Object age = null;
        if(ageInput.matches("")) {
            age = Pet.NOT_INFORMED;
        } else {
            age = pet.commaToPeriod(ageInput);
            pet.validateAge((Double) age);
        }

        System.out.print("Qual o peso aproximado do pet? ");
        String weightInput = sc.nextLine();

        Object weight = null;
        if(weightInput.matches("")) {
            weight = Pet.NOT_INFORMED;
        } else {
            weight = pet.commaToPeriod(weightInput);
            pet.validateWeight((Double) weight);
        }

        System.out.print("Qual a raça do pet? ");
        String raceInput = sc.nextLine();
        String race = (raceInput.matches("")) ? Pet.NOT_INFORMED : raceInput;

        pet = new Pet(name, lastName, type.toUpperCase(), sex.toUpperCase(), age, weight, race, address);

        System.out.println(pet);
    }
}
