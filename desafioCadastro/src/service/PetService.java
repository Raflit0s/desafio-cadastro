package service;

import entity.Pet;
import util.Address;

import java.util.Scanner;

public class PetService {

    private Pet pet = new Pet();

    public void registration() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o nome e sobrenome do seu pet? ");
        String name = sc.next();
        String lastName = sc.next();

        pet.validateName(name, lastName);

        sc.nextLine();
        System.out.print("Qual o tipo do pet (Cachorro/Gato?) ");
        String type = sc.nextLine();

        System.out.print("Qual o sexo do animal? ");
        String sex = sc.nextLine();

        System.out.print("Número da casa: ");
        Integer houseNumber = sc.nextInt();

        sc.nextLine();
        System.out.print("Cidade: ");
        String city = sc.nextLine();

        System.out.print("Rua: ");
        String street = sc.nextLine();

        Address address = new Address(houseNumber, city, street);

        System.out.print("Qual a idade aproximada do pet? (em anos)");
        Double age = sc.nextDouble();

        System.out.print("Qual o peso aproximado do pet? ");
        String weight = sc.nextLine();
        weight.replace(".", ",");

        System.out.print("Qual a raça do pet? ");
        String race = sc.nextLine();

        pet = new Pet(name, lastName, type, sex.toUpperCase(), age, Double.parseDouble(weight), race, address);
    }
}
