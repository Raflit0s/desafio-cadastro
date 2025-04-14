package service;

import entity.Pet;
import entity.Address;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PetService {

    Pet pet = new Pet();
    List<Pet> petList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    int index = 0;

    public void petRegister() {

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
        petList.add(pet);
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

    public void findPet() {

        System.out.print("Qual tipo do seu animal? (Cachorro/Gato) ");
        String type = sc.nextLine();

        Map<Integer, Function<Pet, String>> map = new HashMap<>();
        map.put(1, pet -> pet.getName() + pet.getLastName());
        map.put(2, pet -> pet.getSex().toString());
        map.put(3, pet -> pet.getAge().toString());
        map.put(4, pet -> pet.getWeight().toString());
        map.put(5, Pet::getRace);
        map.put(6, pet -> pet.getAddress().getCity() + pet.getAddress().getStreet() + pet.getAddress().getHouseNumber());

        System.out.println();
        System.out.println("Escolha um ou dois critérios de busca. ");
        System.out.println();

        System.out.println("1 - Nome ou sobrenome\n" +
                "2 - Sexo\n" +
                "3 - Idade\n" +
                "4 - Peso\n" +
                "5 - Raça\n" +
                "6 - Endereço");

        Integer criterionInput = sc.nextInt();
        Function<Pet, String> criterion = map.get(criterionInput);

        sc.nextLine();
        System.out.print("Qual valor buscar? ");
        String value = sc.nextLine();

        petList = petList.stream().filter(x -> x.getType().toString().equals(type.toUpperCase())).filter(x -> {
            String pet = criterion.apply(x);
            if(criterionInput.equals(1) || criterionInput.equals(6)) {
                return pet.toLowerCase().contains(value.toLowerCase());
            } else {
                return pet.equalsIgnoreCase(value);
            }
        }).collect(Collectors.toList());

        System.out.print("Escolha um segundo critério. (deixar em branco caso não precise.) ");
        String criterionInput2 = sc.nextLine().toLowerCase();

        String value2;
        if(!criterionInput2.isEmpty()) {
            Function<Pet, String> criterion2 = map.get(Integer.parseInt(criterionInput2));
            System.out.print("Qual valor buscar? ");
            value2 = sc.nextLine().toLowerCase();

            petList = petList.stream().filter(x -> {
                String pet = criterion2.apply(x);
                if(criterionInput2.equals("1") || criterionInput2.equals("6")) {
                    return pet.toLowerCase().contains(value.toLowerCase());
                } else {
                    return pet.equalsIgnoreCase(value2);
                }
            }).collect(Collectors.toList());
        }

        System.out.println();
        for(Pet x : petList) {
            index = petList.indexOf(x);
            System.out.println(index + ". " + x.getName() + " " + x.getLastName() + " - " + x.getType() + " - "
                    + x.getSex() + " - " + x.getAddress() + " - " + x.getAge() +
                    " anos - " + x.getWeight() + " - " + x.getRace());
        }
        System.out.println();

        }

        public void updatePet() {

        int searchNumber;
        do {
            System.out.println("Busque o pet que deseja alterar:");
            findPet();
            System.out.println();
            do{
            System.out.print("Digite o número do pet que deseja modificar: ");
            searchNumber = sc.nextInt();

            if(searchNumber <= petList.size() - 1) {
                position = petList.get(searchNumber);
                sc.nextLine();
                System.out.print("Insira o novo nome: ");
                String name = sc.nextLine();
                if(!name.trim().isEmpty()) {
                    position.setName(name);
                }
                System.out.print("Insira novo sobrenome: ");
                String lastName = sc.nextLine();
                if(!lastName.trim().isEmpty()) {
                    position.setLastName(lastName);
                }

                System.out.print("Insira nova idade: ");
                String ageInput = sc.nextLine();
                if(!ageInput.trim().isEmpty()) {
                    Double age = pet.commaToPeriod(ageInput);
                    pet.validateAge(age);
                    position.setAge(age);
                }

                System.out.print("Insira novo peso: ");
                String weightInput = sc.nextLine();
                if(!weightInput.trim().isEmpty()) {
                    Double weight = pet.commaToPeriod(weightInput);
                    pet.validateWeight(weight);
                    position.setWeight(weight);
                }

                System.out.print("Insira nova raça: ");
                String race = sc.nextLine();
                if(!race.trim().isEmpty()) {
                    position.setRace(race);
                }

                System.out.println("Insira novo endereço:");
                System.out.print("Número da casa: ");
                String houseNumber = sc.nextLine();
                if(!houseNumber.trim().isEmpty()) {
                    position.setAddress(new Address(Integer.parseInt(houseNumber)));
                }
                System.out.print("Cidade: ");
                String city = sc.nextLine();
                if(!city.trim().isEmpty()) {
                    position.setAddress(new Address(city));
                }
                System.out.print("Rua: ");
                String street = sc.nextLine();
                if(!street.trim().isEmpty()) {
                    position.setAddress(new Address(street));
                }
            } else {
                System.out.println("Número inválido, digite um número de busca válido.");
            }
            }
        }while(petList.get(searchNumber) == null);
        }
}
