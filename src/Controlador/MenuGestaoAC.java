package Controlador;

import DomusDevice.DomusAC;

import java.util.Scanner;

public class MenuGestaoAC extends Menus{
    public MenuGestaoAC(Scanner input){
        super(input, "AC Management Menu.");
    }

    @Override
    public void mostraOpcao(){
        System.out.println("1 - Select Mode.");
        System.out.println("2 - Set Temperature.");
    }

    public void executa(Controlador controlador, int idCasa, int idDivisao, int idDevice){
        int opcao;
        do {
            opcao = lerInput();
            switch (opcao){
                case 1: DomusAC.ModoAC modo = null;
                    while (modo == null) {
                        System.out.println("Modes -> (1- Cold, 2- Warm, 3- Standard): ");
                        int opcaoModo = input.nextInt();
                        modo = switch (opcaoModo) {
                            case 1 -> controlador.aquecerAC(idCasa, idDivisao, idDevice);
                            case 2 -> controlador.arrefecerAC(idCasa, idDivisao, idDevice);
                            case 3 -> DomusAC.ModoAC.VENTILAR;
                            default -> {
                                System.out.println("Non-existent input.");
                                yield null;
                            }
                        };
                    }
                case 2:
            }
        } while(opcao != 0);
    }
}
