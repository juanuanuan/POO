package Controlador;

import java.util.Scanner;
import Controlador.Controlador;

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

    public void executa(Controlador controlador, int idUtilizador) {

        int opcao;
        MenuGestaoCasas menuCasas = new MenuGestaoCasas(input);
        do {
            opcao = lerInput();
            switch(opcao){
                case 1:
                    System.out.println(controlador.listaCasasUtilizador(idUtilizador));
                    break;
                case 2:
                    System.out.println(controlador.listaCasasUtilizador(idUtilizador));
                    break;
                case 3:
                    menuCasas.executa(controlador, idUtilizador);
                    break;
                case 0:
                    System.out.println("Go back.");
                    break;
                case 99:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;    
            }
        }while(opcao != 0);
    }

    
}
