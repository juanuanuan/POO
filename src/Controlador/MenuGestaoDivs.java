package Controlador;

import java.util.Scanner;

public class MenuGestaoDivs extends Menus{

    public MenuGestaoDivs(Scanner input){
        super(input, "Division Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - Select division.");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");

    }
}
