package Controlador;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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
        int tentativa = 0;
        int opcao;
        Random rand = new Random();
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
                        System.out.println("Login as been successful. Welcome back " + user.getNome() + "!\n");
                        mainMenu.executa(controlador, user.getIdUtilizador());
                    } else {
                        System.out.println("Incorrect login. Try again.");
                        tentativa ++;
                    }
                    if(tentativa == 3){ // nao sei se esta a funcionar bem, acho que nao, mas é uma ideia fixe. qualquer cena tira -se
                       System.out.println("Too many incorrect attempts! Try again in a few minutes.\n");
                       System.exit(1);
                    }
                    break;
                case 2:
                    System.out.println("Name: ");
                    String nome = input.nextLine();
                    System.out.println("Email: ");
                    String novoEmail = input.next();
                    System.out.println("Password: ");
                    String novaPassword = input.next(); // ter cuidado com os inputs, se der erro na main é devido ao buffer que não está limpo
                    System.out.println("NIF: ");
                    int novoNif = input.nextInt();
                    System.out.println("Telephone number: ");
                    int novoTlm = input.nextInt();
                    int novoId = controlador.geradorId();
                    Utilizador novoUser = new Utilizador(nome, novoNif, novoTlm, novoEmail, novaPassword, novoId ,new ArrayList<Integer>());
                    controlador.existeConta(novoUser);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Non-existent input.");
                    break;
            }
        }while (opcao != 0);

    }
}
