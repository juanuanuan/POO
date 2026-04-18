package Controlador;

import java.util.Scanner;

public class MainMenu extends Menus{

    public MainMenu(Scanner input){
        super(input, "Welcome to the Main Menu! DomusControl provides you with the most advanced house-management interface. Enjoy!");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - List all your corresponding proprieties.\n");
        System.out.println("2 - List all your own proprieties.\n");
        System.out.println("3 - List all the proprieties you´ve been invited to.\n"); // avança para o menu gestão de casas.
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");
    }
}
