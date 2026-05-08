package Controlador;

import DomusDevice.*;

import java.util.Scanner;

public class MenuGestaoDis extends Menus{
   public  MenuGestaoDis(Scanner input){
       super(input, "Device Management Menu");
   }

   public void mostraOpcao(){
       System.out.println("1 - Add an Air-Condicioner.");
       System.out.println("2 - Add a Lamp.");
       System.out.println("3 - Add a Shutter.");
       System.out.println("4 - Add a Irrigator.");
       System.out.println("5 - Add a SoundSystem.\n");
       System.out.println("0 - Go back.");
       System.out.println("99 - Exit.");
   }

   public void executa(Controlador controlador, int idCasa, int idDivisao){
       int opcao;
       do{
           opcao = lerInput();
           switch (opcao){
               case 1: {
                   ADomusComplexo ac = new DomusAC();
                   controlador.adicionaDispositivo(idCasa, idDivisao, ac);
                   break;
               }

               case 2: {
                   ADomusComplexo lamp = new DomusLampada();
                   controlador.adicionaDispositivo(idCasa, idDivisao, lamp);
                   break;
               }

               case 3: {
                   ADomusSimples shutter = new DomusPercianas();
                   controlador.adicionaDispositivo(idCasa, idDivisao, shutter);
                   break;
               }

               case 4: {
                   ADomusSimples irrigator = new DomusRegador();
                   controlador.adicionaDispositivo(idCasa, idDivisao, irrigator);
                   break;
               }

               case 5: {
                   ADomusSimples soundSys = new DomusSoundSystem();
                   controlador.adicionaDispositivo(idCasa, idDivisao, soundSys);
                   break;
               }

               case 0: {
                   System.out.println("Go back.");
                   break;
               }

               case 99: {
                   System.exit(0);

               }

               default:{
                   System.out.println("Non-existent input");
                   break;
               }

           }

       }while(opcao!=0);
   }
}
