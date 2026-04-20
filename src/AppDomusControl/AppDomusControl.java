package AppDomusControl;

import Controlador.Controlador;
import Controlador.Menus;
import Domus.Casa;
import Domus.Divisao;
import DomusDevice.*;
import Utilizador.Utilizador;
import Utilizador.Utilizadores;
import Controlador.MenuAuth;

import java.util.*;
import java.lang.*;

import java.io.Serializable;

public class AppDomusControl implements Serializable {
    public static void main(String[] args){
        Scanner inpt = new Scanner (System.in);
        Utilizador currentUser = null;
        Scanner input = new Scanner(System.in); // !!! NÃO ESTOU A FAZER A MAIN. APENAS ESTOU A TESTAR COMO FUNCIONAM OS MÉTODOS !!!!
        Random rand = new Random();
        String login1, login2;
        Utilizadores users = new Utilizadores();// colocar aqui no início um ciclo do-while para o programa não estar sempre a fechar.
    
        Menus menu = new MenuAuth(inpt);
/*
        ADomusComplexo dispositivo1 = new DomusLampada(112, "Lampadas Casio", "KX40", 50, 0, 0, 30, true);
        ADomusComplexo dispositivo2 = new DomusLampada(113, "Lampadas Casio", "KX45", 20, 0, 0, 40, true);
        ADomusSimples dispositivo3 = new DomusPercianas(113, "HouseCare.Lda", "P2", 65, 0, 0);
        Divisao div1 = new Divisao("Sala de Estar", 2200, new ArrayList<ADomusSimples>(List.of(dispositivo2)));
        Divisao div2 = new Divisao("Quarto Principal", 2201, new ArrayList<ADomusSimples>(List.of(dispositivo1, dispositivo3)));
        Casa casa = new Casa();
        casa.addDiv(div1);
        casa.addDiv(div2);

        System.out.println("Loading...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println("Fail to load! Check for any corrupted files. Any doubts contact our Support Team!");
        }
        System.out.println(casa.toString());


 */





    Controlador c = new Controlador();
    c.inicializaDadosTeste(); // vês abaixo
    System.out.println("Casa que mais consome: " + c.casaQueMaisConsome().getNomeCasa());
    System.out.println("Top 3 divisões: " + c.top3DivisoesComMaisDevices());
    System.out.println("Top 3 devices por tempo (casa 1): " + c.top3DevicesPorTempo(1));
    System.out.println("Top 3 devices por ativações (casa 1): " + c.top3DevicesPorAtivacoes(1));
        //controller.start();



        /*
        do {

            //Utilizador user = new Utilizador();
            // int inpt;
            // Podemos implementar Thread Sleeps(1/2 segundos) para deixar um programa mais fluido e natural
            System.out.println("  ____                                ____            _             _ ");
            System.out.println(" |  _ \\  ___  _ __ ___  _   _ ___   / ___|___  _ __ | |_ _ __ ___ | |");
            System.out.println(" | | | |/ _ \\| '_ ` _ \\| | | / __| | |   / _ \\| '_ \\| __| '__/ _ \\| |");
            System.out.println(" | |_| | (_) | | | | | | |_| \\__ \\ | |__| (_) | | | | |_| | | (_) | |");
            System.out.println(" |____/ \\___/|_| |_| |_|\\__,_|___/  \\____\\___/|_| |_|\\__|_|  \\___/|_|");
            System.out.println("=======================================================================");
            System.out.println("                               Welcome!                              ");
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
                        System.out.println("Foi-lhe atribuído um Id. Não partilhe este ID com ninguém!" + currentUser.getIdUtilizador()); // esta linha até pode ser interessante. Vamos tentar manter o id escondido
                        // estou a pensar em criar uma classe à parte, chamado Menu.java, com o único objetivo de não andar a poluir a main. a classe main deve ser o mais "burra" e limpa possível
                        // Ou cria se uma classe a parte, ou faz se isto na classe Controlador. Com isso apagamos o switch por completo. Ficando com uma main bastante limpa e legível.
                    } else {
                        System.out.println("O seu logIn de início de sessão está incorreto. Tente novamente.");

                    } break;

                case 2:
                    // registar novo user e os seus metodos
                    String name;
                    int nif;
                    int telemovel;
                    String email;
                    String password;
                    input.nextLine(); // acrescentei aqui um input vazio para o programa não confundir o input do menu com os caracteres do login
                    System.out.println("Primeiro e último nome. \n");
                    name = input.nextLine(); // para nomes (primeiro e último) colocamos sempre nextLine() para o programa ler para além do primeiro espaço.
                    System.out.println("Número de Identificação Fiscal. \n");
                    nif = input.nextInt();
                    System.out.println("Número de Telemóvel. \n");
                    telemovel = input.nextInt();
                    System.out.println("Email. \n");
                    email = input.next(); // como o email é tudo junto e não pode ter espaços, colocamos apenas next()
                    System.out.println("PassWord. \n");
                    password = input.next();
                    int id = rand.nextInt(900000) + 100000; // porque tem estes números? para não gerar números negativos. Também para todos os users terem um Id com 6 dígitos, obtendo um maior range de users e uma maior diferenciação de Id´s.
                    input.nextLine(); // assegurar que o buffer do input é sempre limpo antes de criar outro utilizador ou ao sair do case 2.
                    Utilizador novoUser = new Utilizador(name, nif, telemovel, email, password, id);
                    users.addUser(novoUser);
                    System.out.println(users.getUtilizadores());
                    break;

                case 3:
                    break;
            }
        } while (inpt != 3);

         */
    }


}
