package View;
import Controller.*;

import Model.DomusDevice.DomusAC;

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
        System.out.println("6 - Boost a device.");
        System.out.println("7 - Eco a device.");
        System.out.println("8 - Add Device.");
        System.out.println("9 - AC Management.");
        System.out.println("10 - Set Device Level");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");

    }

    public void executa(Controlador controlador, int idCasa, int idDivisao){

        int opcao;
        MenuGestaoDis menuDis = new MenuGestaoDis(input);
        MenuGestaoDisTemp menuAC = new MenuGestaoDisTemp(input);
        do {
            opcao = lerInput();
            switch(opcao){
                case 1:
                    /*
                    if(!controlador.podeGerir(idCasa)){
                    System.out.println("No permission to execute.");
                    break;
                }

                     */
                    System.out.println(controlador.listaDispositivos(idCasa, idDivisao)); 
                    break;
                case 2:
                    /*
                    if(!controlador.podeGerir(idCasa)){
                        System.out.println("No permission to execute.");
                        break;
                    }

                     */
                    System.out.println(controlador.top1DeviceConsumo(idCasa));
                    break;
                case 3: {
                    System.out.println("Top 3 by time: " + controlador.top3DevicesPorTempoDivisao(idCasa, idDivisao));
                    System.out.println("Top 3 by activations: " + controlador.top3DevicesPorAtivacoesDivisao(idCasa, idDivisao));
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
                    menuDis.executa(controlador, idCasa, idDivisao);
                    break;
                }

                case 9: {
                    System.out.println(controlador.listaDispositivos(idCasa, idDivisao));
                    System.out.println("Device ID: ");
                    int id = input.nextInt();
                    if(!(controlador.getDispositivo(idCasa, idDivisao, id) instanceof DomusAC)){ // pouco orientado em OOP, mas teve de ser, se não fosse assim íamos ter complicações.
                        System.out.println("Device not found.");
                        break;
                    }
                    menuAC.executa(controlador, idCasa, idDivisao, id);
                    break;
                }

                case 10: {
                    System.out.println("Device ID:");
                    int id = input.nextInt();
                    System.out.println("Level: ");
                    double nivel = input.nextDouble();
                    System.out.println("Device with ID: " + id + "is leveled at: " + nivel);
                    controlador.setNivelDevice(idCasa, idDivisao, id, nivel);
                    break;
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
