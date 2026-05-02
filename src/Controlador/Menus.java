package Controlador;

import Domus.Casa;
import Utilizador.Utilizador;
import Utilizador.Utilizadores;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Menus{
      protected String nomeMenu;
      protected Scanner input;

      public Menus(Scanner input, String nomeMenu){
          this.input = input;
          this.nomeMenu = nomeMenu;
      }

      public abstract void mostraOpcao();


      public int lerInput(){
          System.out.println("\n ==== " + this.nomeMenu + "====\n");
          this.mostraOpcao();
          int opcao = input.nextInt();
          input.nextLine();
          return opcao;
      }

}

