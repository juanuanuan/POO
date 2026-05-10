package Controlador;
import java.util.Random;

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
                   int id = controlador.geradorId();
                   System.out.println("Manufacture: ");
                   String marca = input.nextLine();
                   System.out.println("Model: ");
                   String modelo = input.nextLine();
                   System.out.println("Base Consumption: ");
                   double consumo = input.nextDouble();
                   input.nextLine();
                   System.out.println("Mode -> Standard (Ventilating)");
                   DomusAC.ModoAC modo = DomusAC.ModoAC.VENTILAR;

                   ADomusComplexo ac = new DomusAC(id, marca, modelo, consumo, 0, 0, 0, 0, 0, 16, modo);
                   controlador.adicionaDispositivo(idCasa, idDivisao, ac);
                   break;
               }

               case 2: {
                   int id = controlador.geradorId();
                   System.out.println("Manufacture: ");
                   String marca = input.nextLine();
                   System.out.println("Model: ");
                   String modelo = input.nextLine();
                   System.out.println("Base Consumption: ");
                   double consumo = input.nextDouble();
                   input.nextLine();
                   ADomusComplexo lamp = new DomusLampada(id, marca, modelo, consumo, 0, 0, true, 0, 0, 0, 0);
                   controlador.adicionaDispositivo(idCasa, idDivisao, lamp);
                   break;
               }

               case 3: {
                   int id = controlador.geradorId();
                   System.out.println("Manufacture: ");
                   String marca = input.nextLine();
                   System.out.println("Model: ");
                   String modelo = input.nextLine();
                   System.out.println("Base Consumption: ");
                   double consumo = input.nextDouble();
                   input.nextLine();
                   ADomusSimples shutter = new DomusPercianas(id, marca, modelo, consumo, 0, 0, 0, 0,  0);
                   controlador.adicionaDispositivo(idCasa, idDivisao, shutter);
                   break;
               }

               case 4: {
                   int id = controlador.geradorId();
                   System.out.println("Manufacture: ");
                   String marca = input.nextLine();
                   System.out.println("Model: ");
                   String modelo = input.nextLine();
                   System.out.println("Base Consumption: ");
                   double consumo = input.nextDouble();
                   input.nextLine();
                   ADomusSimples irrigator = new DomusRegador(id, marca, modelo, consumo, 0, 0, 0, 0, 0, 0);
                   controlador.adicionaDispositivo(idCasa, idDivisao, irrigator);
                   break;
               }

               case 5: {
                   int id = controlador.geradorId();
                   System.out.println("Manufacture: ");
                   String marca = input.nextLine();
                   System.out.println("Model: ");
                   String modelo = input.nextLine();
                   System.out.println("Base Consumption: ");
                   double consumo = input.nextDouble();
                   System.out.println("Radio Station: ");
                   String estacao = input.nextLine();
                   ADomusSimples soundSys = new DomusSoundSystem(id, marca, modelo, consumo, 0, estacao, 0, 0, 0, 0);
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
