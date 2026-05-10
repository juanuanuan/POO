package AppDomusControl;

import Controlador.Controlador;
import Controlador.MenuAuth;
import DomusDevice.DomusLampada;
import Utilizador.Utilizador;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppDomusControl {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flagPopulate = false;
        Controlador controlador = Controlador.carregaEstado("estado.dat");
        if(flagPopulate) {
            //controlador = new Controlador();
            popular(controlador);
        }
        MenuAuth menuAuth = new MenuAuth(input);
        menuAuth.executa(controlador);

        controlador.guardaEstado("estado.dat");



    }


    public static void popular(Controlador controlador) {

        Utilizador u1 = new Utilizador("joao", 267316020, 938756690, "joao@gmail.com", "1234", 50098, new ArrayList<>());
        Utilizador u2 = new Utilizador("zeca", 987654321, 923456789, "zeca@gmail.com", "4321", 2, new ArrayList<>());
        controlador.getUtilizadores().addUser(u1);
        controlador.getUtilizadores().addUser(u2);

        controlador.adicionaCasa(50098, 1, "Rua A", "Casa Principal");
        controlador.adicionaCasa(50098, 2, "Rua B", "Casa de Ferias");
        controlador.adicionaGuest(1, 2);

        controlador.adicionaDivisao(1, "Sala",    1);
        controlador.adicionaDivisao(1, "Quarto",  2);

        controlador.adicionaDivisao(2, "Cozinha",    3);
        controlador.adicionaDivisao(2, "Escritório", 4);

        controlador.adicionaDispositivo(1, 1, new DomusLampada(1, "Philips", "HUE",      10.0, 10.0, 2700, true,  0, 0, 0, 50.0));
        controlador.adicionaDispositivo(1, 1, new DomusLampada(2, "Ikea",    "Tradfri",   8.0,  8.0,    0, false, 0, 0, 0, 30.0));
        controlador.adicionaDispositivo(1, 1, new DomusLampada(3, "Xiaomi",  "Yeelight",  9.0,  9.0, 4000, true,  0, 0, 0, 70.0));

        controlador.adicionaDispositivo(1, 2, new DomusLampada(4, "Philips", "HUE2",     12.0, 12.0, 3000, true,  0, 0, 0, 80.0));

        controlador.adicionaDispositivo(2, 3, new DomusLampada(5, "Osram",   "Smart+",    7.0,  7.0,    0, false, 0, 0, 0, 40.0));
        controlador.adicionaDispositivo(2, 3, new DomusLampada(6, "Ikea",    "Tradfri2",  6.0,  6.0,    0, false, 0, 0, 0, 20.0));

        controlador.adicionaDispositivo(2, 4, new DomusLampada(7, "Philips", "HUE3",     11.0, 11.0, 2700, true,  0, 0, 0, 60.0));

        controlador.ligaDispositivo(1, 1, 1);
        controlador.ligaDispositivo(1, 1, 2);
        controlador.ligaDispositivo(1, 1, 3);
        controlador.ligaDispositivo(1, 2, 4);
        controlador.setTempoAtual(120);
        controlador.desligaDispositivo(1, 1, 1);
        controlador.desligaDispositivo(1, 1, 2);
        controlador.desligaDispositivo(1, 1, 3);
        controlador.desligaDispositivo(1, 2, 4);

        controlador.ligaDispositivo(2, 3, 5);
        controlador.ligaDispositivo(2, 3, 6);
        controlador.setTempoAtual(150);
        controlador.desligaDispositivo(2, 3, 5);
        controlador.desligaDispositivo(2, 3, 6);

        controlador.ligaDispositivo(1, 1, 1);
        controlador.setTempoAtual(200);
        controlador.ligaDispositivo(1, 1, 3);
    }
}

