package AppDomusControl;

import Utilizador.Utilizador;
import Utilizador.Utilizadores;
import java.util.Random;

import java.io.Serializable;
import java.util.Scanner;

public class AppDomusControl implements Serializable {
    public static void main(String[] args){
        int inpt;
        Utilizador currentUser = null;
        Scanner input = new Scanner(System.in); // !!! NÃO ESTOU A FAZER A MAIN. APENAS ESTOU A TESTAR COMO FUNCIONAM OS MÉTODOS !!!!
        Random rand = new Random();
        String login1, login2;
        Utilizadores users = new Utilizadores(); // colocar aqui no início um ciclo do-while para o programa não estar sempre a fechar.
        do {

            //Utilizador user = new Utilizador();
            // int inpt;
            System.out.println("  ____                                ____            _             _ ");
            System.out.println(" |  _ \\  ___  _ __ ___  _   _ ___   / ___|___  _ __ | |_ _ __ ___ | |");
            System.out.println(" | | | |/ _ \\| '_ ` _ \\| | | / __| | |   / _ \\| '_ \\| __| '__/ _ \\| |");
            System.out.println(" | |_| | (_) | | | | | | |_| \\__ \\ | |__| (_) | | | | |_| | | (_) | |");
            System.out.println(" |____/ \\___/|_| |_| |_|\\__,_|___/  \\____\\___/|_| |_|\\__|_|  \\___/|_|");
            System.out.println("=======================================================================");
            System.out.println("                             Bem-vindo/(a)!                               ");
            System.out.println("=======================================================================");
            System.out.println("         1- Login         2- Create Account          3- Exit               ");
            System.out.println("=======================================================================");
            inpt = input.nextInt();
            switch (inpt) {
                case 1:
                    System.out.println("Digite o seu email.");
                    login1 = input.next();
                    System.out.println("Digite a palavra-passe.");
                    login2 = input.next();
                    currentUser = users.efetuaLogin(login1, login2);
                    if (currentUser != null) {
                        System.out.println(currentUser.getIdUtilizador()); // apagar esta linha, é apenas para saber se o programa aceita um utilizador!
                    } else {
                        System.out.println("O seu logIn de início se sessão esta incorreto. Tente novamente;");
                        break;
                    }

                case 2:
                    // registar novo user e os seus metodos
                    String name;
                    int nif;
                    int telemovel;
                    String email;
                    String password;
                    input.nextLine(); // acrescentei aqui um input vazio para o programa não confundir o input do menu com os caracteres do login
                    System.out.println("Primeiro e ultimo nome. \n");
                    name = input.nextLine(); // para nomes (primeiro e último) colocamos sempre nextLine() para o programa ler para além do primeiro espaço.
                    System.out.println("Numero de Identificação Fiscal. \n");
                    nif = input.nextInt();
                    System.out.println("Numero de Telemóvel. \n");
                    telemovel = input.nextInt();
                    System.out.println("Email. \n");
                    email = input.next(); // como o email é tudo junto e não pode ter espaços, colocamos apenas next()
                    System.out.println("PassWord. \n");
                    password = input.next();
                    int id = rand.nextInt(900000) + 100000; // porque tem estes números? para não gerar números negativos. Também para todos os users terem um Id com 6 dígitos, abrangendo um maior range de users e maior diferenciação de Id´s.

                    Utilizador novoUser = new Utilizador(name, nif, telemovel, email, password, id);
                    users.addUser(novoUser);
                    System.out.println(users.getUtilizadores());
                    break;

                case 3:
                    break;
            }
        } while (inpt != 3);
    }
}
