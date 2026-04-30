package Controlador;

import java.util.Scanner;
import Controlador.Controlador;

public class MenuGestaoDiv extends Menus{

    public MenuGestaoDiv(Scanner input){
        super(input, "Single Division Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - List all your devices.");
        System.out.println("2 - Consult the top consuming device.");
        System.out.println("3 - Consult division stats.");
        System.out.println("4 - Turn on a device.");
        System.out.println("5 - Turn off a device.");
        System.out.println("0 - Go back");
        System.out.println("99 - Exit");

    }

    public void executa(Controlador controlador, int idCasa, int idDivisao){

        int opcao;
        do {
            opcao = lerInput();
            switch(opcao){
                case 1: 
                    System.out.println(controlador.listaDispositivos(idCasa, idDivisao)); 
                    break;
                case 2: System.out.println(controlador.top3DevicesPorTempo(idCasa));
                    break;
                case 3: {
                    System.out.println("Top 3 por tempo: " + controlador.top3DevicesPorTempo(idCasa));
                    System.out.println("Top 3 por ativações: " + controlador.top3DevicesPorAtivacoes(idCasa));
                    break;
                }
                case 4: {
                    System.out.println("Device ID: ");
                    int id = input.nextInt();
                    controlador.ligaDispositivo(idCasa, idDivisao, id);
                    System.out.println("Dispositivo " + id + " ligado");
                    break;
                }

                case 5: {
                    System.out.println("Device ID: ");
                    int id = input.nextInt();
                    controlador.desligaDispositivo(idCasa, idDivisao, id);
                    System.out.println("Dispositivo " + id + " desligado");
                    break;
                }
                case 0: System.out.println("voltar atras. ");
                    break;
                case 99: System.exit(0);
                    break;
            }
            
        }
            while(opcao != 0);
    }
}
