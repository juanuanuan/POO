package Controlador;

import java.util.Scanner;

public class MenuAuth extends Menus{

    public MenuAuth(Scanner input){
        super(input, "Welcome to the Authentication Menu. For any inconveniences, contact our support team.");
    }


    @Override
    public void mostraOpcao(){
        System.out.println("1- Login\n");
        System.out.println("2- Create Account\n");
        System.out.println("3- Exit\n");
    }
}
