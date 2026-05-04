package Controlador;

import java.util.Scanner;

public class MenuGestaoDivs extends Menus{

    public MenuGestaoDivs(Scanner input){
        super(input, "Division Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - Select division.");
        System.out.println("2 - Shutdown Mode.\n");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");

    }

    public void executa(Controlador controlador, int idCasa){

        int opcao;
        MenuGestaoDiv menuDiv = new MenuGestaoDiv(input);

        do {
            opcao = lerInput();
            switch(opcao){
                case 1:  {
                    System.out.println(controlador.listaDivisoes(idCasa));
                    System.out.println("Division ID: ");
                    int idDivisao = input.nextInt();
                    menuDiv.executa(controlador, idCasa, idDivisao);
                    break;
                }

                case 2: {
                    System.out.println("The SM (Shutdown Mode) turns off all your devices. Only the owner, or any user with such permissions is able to shutdown");
                    if(controlador.ehHost()){
                        controlador.desligaAllDevice(idCasa);
                    } else System.out.println("Permission denied.\n");
                    break;
                }
                case 0: 
                    System.out.println("Go back.");
                    break;
                case 99: System.exit(0);
                    break;
                default: System.out.println("Non-existent input.");
                    break;


            }
        } while(opcao != 0);
    }
}
