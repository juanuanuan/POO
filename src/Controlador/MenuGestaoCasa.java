package Controlador;

import java.util.Scanner;

public class MenuGestaoCasa extends Menus{

    public MenuGestaoCasa(Scanner input){
        super(input, "Single Propriety Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - List all users.");
        System.out.println("2 - List guests.");
        System.out.println("3 - List hosts");
        System.out.println("4 - Consult real time propriety consumption.");
        System.out.println("5 - Consult monthly propriety consumption");
        System.out.println("6 - Show the top consuming division.");
        System.out.println("7 - Remove user.");
        System.out.println("8 - Add user.");
        System.out.println("9 - Implement user permissions."); // na dúvida se esta linha vai realmente existir...
        System.out.println("12 - Add division.");
        System.out.println("13 - Remove division.");
        System.out.println("14 - Division management.");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");


    }
}
