package AppDomusControl;

import Controlador.Controlador;
import Controlador.MenuAuth;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppDomusControl {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Controlador controlador = Controlador.carregaEstado("estado.dat");
        if(controlador == null) {
            controlador = new Controlador();
            controlador.instantTest();
        }
        MenuAuth menuAuth = new MenuAuth(input);
        menuAuth.executa(controlador);
    }
}

