package util;

import service.PetService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    PetService petService = new PetService();

    public void initialMenu() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("1. Cadastrar um novo pet\n")
                .append("2. Alterar os dados do pet cadastrado\n")
                .append("3. Listar pets por algum critério (idade, nome, raça)\n")
                .append("4. Deletar um pet cadastrado\n")
                .append("5. Sair");

        int input = 0;
        try {
            do {
                System.out.println(sb);
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        petService.petRegister();
                        break;
                    case 2:
                        petService.updatePet();
                        break;
                    case 3:
                        petService.findPet();
                        break;
                    case 4:
                        petService.deletePet();
                        break;
                    case 5:
                        System.out.println("Programa encerrado.");
                        break;
                }
            } while (input != 5);
        } catch(InputMismatchException e) {
        System.out.println("Apenas números inteiros são válidos");
    }
        sc.close();
    }
}
