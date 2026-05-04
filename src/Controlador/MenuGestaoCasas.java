package Controlador;

import java.util.Random;
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
                    //controlador.adicionaCasa();
                    System.out.println("Propriety Id: ");
                    int idCasaNova = rand.nextInt(Integer.MAX_VALUE); // vi isto no javadoc, assim e muito difícil haver os mesmos ‘ids’
                    System.out.println("Address: ");
                    String morada = input.next();
                    System.out.println("Household name: ");
                    String nomeCasa = input.next();
                    controlador.adicionaCasa(idUtilizador, idCasaNova, morada, nomeCasa);
                    System.out.println("Propriety added.\n");
                    break;
                case 5:
                    System.out.println(controlador.listaCasasUtilizador(idUtilizador));
                    System.out.println("Propriety Id:");
                    int idCasa = input.nextInt();
                    menuCasa.executa(controlador, idCasa);
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
