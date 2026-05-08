package Controlador;

import java.util.Scanner;

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
        System.out.println("6 - Boost a device");
        System.out.println("7 - Eco a device");
        System.out.println("8 - Add Device");
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
                case 2:
                    System.out.println(controlador.top1DeviceConsumo(idCasa)); // mudar aqui para o mais consumidor, e não os 3
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
                    System.out.println("Device with ID: " + id + " is ON\n");
                    break;
                }

                case 5: {
                    System.out.println("Device ID: ");
                    int id = input.nextInt();
                    controlador.desligaDispositivo(idCasa, idDivisao, id);
                    System.out.println("Device: " + id + " is OFF");
                    break;
                }

                case 6: {
                    System.out.println("Device ID: ");
                    int id = input.nextInt();
                    controlador.boostDevice(idCasa, idDivisao, id);
                    System.out.println("Device with ID: " + id + " is in BOOST mode.\n");
                    break;
                }

                case 7: {
                    System.out.println("Device ID: ");
                    int id = input.nextInt();
                    controlador.ecoDevice(idCasa, idDivisao, id);
                    System.out.println("Device with ID: " + id + " is in ECO mode.\n");
                    break;
                }

                case 8: {
                    MenuGestaoDis menuDis = new MenuGestaoDis(input);
                    menuDis.executa(controlador, idCasa, idDivisao);
                }
                case 0: System.out.println("Go back.\n");
                    break;
                case 99: System.exit(0);
                    break;
            }
            
        }
            while(opcao != 0);
    }
}
