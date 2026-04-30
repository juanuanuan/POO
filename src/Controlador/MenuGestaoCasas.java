package Controlador;

import java.util.Scanner;
import Controlador.Controlador;

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
        
        int opcao;
        MenuGestaoCasa menuCasa = new MenuGestaoCasa(input);
        do{
            opcao = lerInput();
            switch(opcao){
                case 3:
                    //controlador.removeCasa();
                    System.out.println("ID da casa a remover: ");
                    int idRemover = input.nextInt();
                    controlador.removeCasa(idUtilizador, idRemover);
                    System.out.println("Casa removida.");
                    break;
                case 4: 
                    //controlador.adicionaCasa();
                    System.out.println("ID da casa: ");
                    int idCasaNova = input.nextInt();
                    System.out.println("Morada: ");
                    String morada = input.next();
                    System.out.println("Nome da casa: ");
                    String nomeCasa = input.next();
                    controlador.adicionaCasa(idUtilizador, idCasaNova, morada, nomeCasa);
                    System.out.println("Casa adicionada.");
                    break;
                case 5:
                    System.out.println(controlador.listaCasasUtilizador(idUtilizador));
                    System.out.println("ID da casa: ");
                    int idCasa = input.nextInt();
                    menuCasa.executa(controlador, idCasa);
                    break;
                case 0:
                    System.out.println("voltar atras.");
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
