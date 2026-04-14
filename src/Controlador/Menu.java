package Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.time.LocalDate;


// Classe abstrata Menu. Aqui fica uma série de menus e subMenus.
public abstract class Menu {
    protected Scanner input;
    protected Controlador controlador;


    //public abstract Menu executarMenu();

}
