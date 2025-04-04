package util;

import java.io.*;

public class Form {

    public void createForm() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Rafael\\IdeaProjects\\desafioCadastro\\desafioCadastro\\formulario.txt"))) {

            bw.write("1 - Qual o nome e sobrenome do pet?\n");
            bw.write("2 - Qual o tipo do pet (Cachorro/Gato?)\n");
            bw.write("3 - Qual o sexo do animal?\n");
            bw.write("4 - Qual endereço e bairro que ele foi encontrado?\n");
            bw.write("5 - Qual a idade aproximada do pet?\n");
            bw.write("6 - Qual o peso aproximado do pet?\n");
            bw.write("7 - Qual a raça do pet?\n");

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void readForm() {
        try(BufferedReader br = new BufferedReader( new FileReader("C:\\Users\\Rafael\\IdeaProjects\\desafioCadastro\\desafioCadastro\\formulario.txt"))) {

            String line = br.readLine();
            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
