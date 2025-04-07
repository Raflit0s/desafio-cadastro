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
                .append("3. Deletar um pet cadastrado\n")
                .append("4. Listar todos os pets cadastrados\n")
                .append("5. Listar pets por algum critério (idade, nome, raça)\n")
                .append("6. Sair");

        int input = 0;
        try {
            do {
                System.out.println(sb);
                input = sc.nextInt();
                switch (input) {
                    case 1:
                        petService.registration();
                }
            } while (input != 6);
        } catch(InputMismatchException e) {
        System.out.println("Apenas números inteiros são válidos");
    }
        sc.close();
    }
}
