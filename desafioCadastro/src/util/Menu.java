package util;

public class Menu {

    public void initialMenu() {
             StringBuilder sb = new StringBuilder("1. Cadastrar um novo pet\n")
                .append("2. Alterar os dados do pet cadastrado\n")
                .append("3. Deletar um pet cadastrado\n")
                .append("4. Listar todos os pets cadastrados\n")
                .append("5. Listar pets por algum critério (idade, nome, raça)\n")
                .append("6. Sair");

             System.out.println(sb);
    }
}
