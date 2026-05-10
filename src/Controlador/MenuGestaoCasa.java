package Controlador;

import java.util.Scanner;

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
        System.out.println("6 - Show the top 3 consuming divisions.");
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
                    System.out.println(controlador.listaGuests(idCasa));
                    System.out.println(controlador.listaHost(idCasa));
                    break;
                case 2: 
                    System.out.println(controlador.listaGuests(idCasa));
                    break;
                case 3:
                    System.out.println(controlador.listaHost(idCasa));
                    break;    
                case 4: 
                    System.out.println("Current propriety consumption: " + controlador.getConsumoCasa(idCasa) + " Wh");
                    break;
                case 5:
                    System.out.println("Consumo mensal da casa: " + controlador.getConsumoMensalCasa(idCasa) + " Wh");
                    break;
                case 6:
                    System.out.println("Top 3 most consuming divisions: " + controlador.top3DivisoesComMaisDevices());
                    break;
                case 7:
                    System.out.println("ID do guest a remover: ");
                    int idRemover = input.nextInt();
                    controlador.removeGuest(idCasa, idRemover);
                    System.out.println("Guest removido.");
                    break;
                case 8:
                    System.out.println("ID do utilizador a adicionar: ");
                    int idGuest = controlador.geradorId();
                    controlador.adicionaGuest(idCasa, idGuest);
                    System.out.println("Guest adicionado.");
                    break;
                case 9: 
                    System.out.println("Funcionalidade ainda nao implementada.");
                    break;
                case 12: 
                    System.out.println("Division name: ");
                    String nomeDivisao = input.nextLine();
                    System.out.println("Division Id: ");
                    int idDivisao = controlador.geradorId();
                    controlador.adicionaDivisao(idCasa, nomeDivisao, idDivisao);
                    System.out.println("Division added.\n");
                    break;
                case 13:
                    System.out.println("To-remove division Id: ");
                    int idDiv = input.nextInt();
                    controlador.removeDivisao(idCasa, idDiv);
                    System.out.println("Division removed.\n");
                    break;
                case 14:
                    menuDivs.executa(controlador, idCasa);
                    break;
                case 0:
                    System.out.println("Go back.");

                    break;
                case 99: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Non-existent input.");
                    break;
            }
        } while(opcao != 0);
    }
}
