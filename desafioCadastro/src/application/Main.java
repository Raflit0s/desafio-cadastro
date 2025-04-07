package application;

import util.Form;
import util.Menu;

public class Main {
    public static void main(String[] args) {
        Form form = new Form();
        Menu menu = new Menu();

        form.createForm();
        form.readForm();
        System.out.println();
        menu.initialMenu();
        }
    }