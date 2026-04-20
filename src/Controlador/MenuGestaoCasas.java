package Controlador;

import java.util.Scanner;

public class MenuGestaoCasas extends Menus{

    public MenuGestaoCasas(Scanner input){
        super(input, "Proprieties Management Menu." );

    }

    @Override
    public void mostraOpcao(){

        System.out.println("3 - Remove Propriety from the data base.");
        System.out.println("4 - Add propriety to the data base.");
        System.out.println("5 - Single house management.");
        System.out.println("6 - List the top 3 most consuming proprieties.");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");
    }
}
