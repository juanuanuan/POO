package Controlador;

import java.util.Scanner;
import Controlador.Controlador;

public class MenuGestaoCasa extends Menus{

    public MenuGestaoCasa(Scanner input){
        super(input, "Single Propriety Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - List all users.");
        System.out.println("2 - List guests.");
        System.out.println("3 - List hosts");
        System.out.println("4 - Consult real time propriety consumption.");
        System.out.println("5 - Consult monthly propriety consumption");
        System.out.println("6 - Show the top consuming division.");
        System.out.println("7 - Remove user.");
        System.out.println("8 - Add user.");
        System.out.println("9 - Implement user permissions."); // na dúvida se esta linha vai realmente existir...
        System.out.println("12 - Add division.");
        System.out.println("13 - Remove division.");
        System.out.println("14 - Division management.");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");
    }

    public void executa(Controlador controlador, int idCasa){

        int opcao;
        MenuGestaoDivs menuDivs = new MenuGestaoDivs(input);
        do{
            opcao = lerInput();
            switch(opcao){
                case 1:
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 2: 
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 3:
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;    
                case 4: 
                    System.out.println("Consumo atual da casa: " + controlador.getConsumoCasa(idCasa) + " Wh");
                    break;
                case 5:
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 6:
                    System.out.println("Top 3 divisoes com mais devices: " + controlador.top3DivisoesComMaisDevices());
                    break;
                case 7:
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 8:
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 9: 
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 12: 
                    System.out.println("Nome da divisao: ");
                    String nomeDivisao = input.next();
                    System.out.println("ID da divisao: ");
                    int idDivisao = input.nextInt();
                    controlador.adicionaDivisao(idCasa, nomeDivisao, idDivisao);
                    System.out.println("Divisao adicionada.");
                    break;
                case 13:
                    System.out.println("ID da divisao a remover: ");
                    int idDiv = input.nextInt();
                    controlador.removeDivisao(idCasa, idDiv);
                    System.out.println("Divisao removida.");
                    break;
                case 14:
                    menuDivs.executa(controlador, idCasa);
                    break;
                case 0:
                    System.out.println("voltar atras.");
                    break;
                case 99: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("opcao invalida."); 
                    break;
            }
        } while(opcao != 0);
    }
}
