package service;

import entity.Pet;
import util.Address;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PetService {

    private Pet pet = new Pet();

    public void registration() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Qual o nome do seu pet?");
        String name = sc.nextLine();

        System.out.print("Qual o sobrenome do seu pet?");
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
        saveInfile(pet);
    }

    public void saveInfile(Pet pet) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd HHmm");
            String dateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()).format(fmt);
            StringBuilder nomeCompleto = new StringBuilder(pet.getName()).append(pet.getLastName());
            File file = new File("C:\\Users\\Rafael\\IdeaProjects\\desafioCadastro\\desafioCadastro\\petsCadastrados\\"
                    + dateTime.replace(" ", "T") + "-" + nomeCompleto.toString().toUpperCase() + ".txt");

            try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
                br.write(pet.toString());
                System.out.println("Arquivo criado com sucesso!");
            } catch (IOException e) {
                System.out.println("Não foi possível criar o arquivo");
            }
        }
    }
