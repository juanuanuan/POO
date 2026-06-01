package Controlador;


import java.util.Scanner;

public class MenuGestaoDisTemp extends Menus{
    public MenuGestaoDisTemp(Scanner input){
        super(input, "AC Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - Select Mode.");
        System.out.println("2 - Set Temperature.");
        System.out.println("0 - Go back.");
        System.out.println("99 - Exit.");

    }

    public void executa(Controlador controlador, int idCasa, int idDivisao, int idDevice){
        int opcao;
        do {
            opcao = lerInput();
            switch (opcao){
                case 1:
                        System.out.println("Modes -> (1- Warm, 2- Cold, 3- Standard): ");
                        int opcaoModo = input.nextInt();
                        switch (opcaoModo) {
                            case 1 -> {
                                controlador.aquecer(idCasa, idDivisao, idDevice);
                                controlador.ligaDispositivo(idCasa, idDivisao, idDevice);
                            }
                            case 2 -> {
                                controlador.arrefecer(idCasa, idDivisao, idDevice);
                                controlador.ligaDispositivo(idCasa, idDivisao, idDevice);
                            }
                            case 3 -> {
                                controlador.ventilar(idCasa, idDivisao, idDevice);
                                controlador.ligaDispositivo(idCasa, idDivisao, idDevice);
                            }
                            default -> {
                                System.out.println("Non-existent input.");
                                break;
                            }
                        }
                case 2:
                        System.out.println("Select the desired temperature (16-30).");
                        int temp = input.nextInt();
                        controlador.setTemperatura(idCasa, idDivisao, idDevice, temp);
                        break;

                case 0:
                        System.out.println("Go back.");
                        break;

                case 99:
                    System.exit(0);


                default: System.out.println("Non-existent input."); break;
            }
        } while(opcao != 0);
    }
}
