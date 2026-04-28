package Controlador;

import java.util.Scanner;
import Controlador.Controlador; 

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

    public void executa(Controlador controlador, int idCasa, int idDivisao){

        int opcao;
        MenuGestaoDiv menuDiv = new MenuGestaoDiv(input);

        do {
            opcao = lerInput();
            switch(opcao){
                case -> 1 {
                    System.out.println(controlador.listaDivisoes(idCasa));
                    System.out.println("ID divisao: ");
                    int idDivisao = input.nextInt();
                    menuDiv.executa(controlador, idCasa, idDivisao);
                }
                case 0 -> System.out.println("voltar atras.");
                case 99 -> System.exit(0);
                //default -> System.out.println("opcao invalida.");


            }
        } while(opcao != 0);
    }
}
