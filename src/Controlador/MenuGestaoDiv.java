package Controlador;

import java.util.Scanner;

public class MenuGestaoDiv extends Menus{

    public MenuGestaoDiv(Scanner input){
        super(input, "Single division management.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - List all your devices.");
        System.out.println("2 - Consult the top consuming device.");
        System.out.println("3 - Consult division stats.");
        System.out.println("0 - Go back");
        System.out.println("99 - Exit");

    }
}
