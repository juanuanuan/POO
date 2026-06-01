package Controlador;

import java.util.Random;
import java.util.Scanner;

public class MenuGestaoCasas extends Menus{

    public MenuGestaoCasas(Scanner input){
        super(input, "Proprieties Management Menu.");

    }

    @Override
    public void mostraOpcao(){

        System.out.println("3 - Remove Propriety from the data base.");
        System.out.println("4 - Add propriety to the data base.");
        System.out.println("5 - Single house management.");
        System.out.println("6 - List the most consuming propriety.");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");
    }

    public void executa(Controlador controlador, int idUtilizador){
        Random rand = new Random();
        int opcao;
        MenuGestaoCasa menuCasa = new MenuGestaoCasa(input);
        do{
            opcao = lerInput();
            switch(opcao){
                case 3:
                    //controlador.removeCasa();
                    System.out.println("To-remove Propriety: ");
                    int idRemover = input.nextInt();
                    controlador.removeCasa(idUtilizador, idRemover);
                    System.out.println("Propriety has been removed.\n");
                    break;
                case 4:
                    int idCasaNova = controlador.geradorId();
                    System.out.println("Address: ");
                    String morada = input.nextLine();
                    System.out.println("Household name: ");
                    String nomeCasa = input.nextLine();
                    controlador.adicionaCasa(idUtilizador, idCasaNova, morada, nomeCasa);
                    System.out.println("Propriety added.\n");
                    break;
                case 5:
                    System.out.println(controlador.listaCasasUtilizador(idUtilizador));
                    System.out.println("Propriety Id: ");
                    int idCasa = input.nextInt();
                    if(controlador.getUtilizadores().getUtilizadores().get(idUtilizador).getIdCasas().contains(idCasa)) {
                        menuCasa.executa(controlador, idCasa);
                    } else {
                        System.out.println("Nao tem acesso a esta casa.");
                    }
                    break;

                case 6:
                    System.out.println(controlador.casaQueMaisConsome().toString());
                    break;
                case 0:
                    System.out.println("Go back.\n");
                    break;
                case 99:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Non-existent input.\n");
                    break;
            }
        }while(opcao != 0);
    }
}
