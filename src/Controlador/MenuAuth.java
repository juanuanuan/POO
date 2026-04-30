package Controlador;

import java.util.Scanner;
import Controlador.Controlador;
import Utilizador.Utilizador;

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

    public void executa(Controlador controlador){

        int opcao;
        MainMenu mainMenu = new MainMenu(input);
        do{
            opcao = lerInput();
            switch(opcao){
                case 1:
                    System.out.println("Email: ");
                    String email = input.next();
                    System.out.println("Password: ");
                    String password = input.next();
                    Utilizador user = controlador.getUtilizadores().efetuaLogin(email, password);
                    if(user != null) {
                        System.out.println("Login efetuado com sucesso! Bem-vindo de volta " + user.getNome());
                        mainMenu.executa(controlador, user.getIdUtilizador());
                    } else {
                        System.out.println("Email ou password incorretos.");
                    }
                    break;
                case 2: 
                    System.out.println("Nome: ");
                    String nome = input.next();
                    System.out.println("Email: ");
                    String novoEmail = input.next();
                    System.out.println("Password: ");
                    String novaPassword = input.next();
                    // trato disto depois chamar metodo de registo no controlador
                break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        }while (opcao != 0);

    }
}
