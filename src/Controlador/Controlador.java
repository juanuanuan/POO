package Controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.io.*;

import Domus.Casa;
import Utilizador.Utilizador;
import Utilizador.Utilizadores;

public class Controlador implements Serializable {
    // Recebe métodos que salvam e carregam o estado da aplicação
    // lê ficheiros, recebe os metodos DomusDevice para criação de duplicatos.

    // nao sei bem o propósito desta classe, se fica so para gestão do estado da aplicação, ou se lhe passamos métodos de controlo sobre os utilizadores, i.e., login registo, etc

    private Utilizadores utilizadores; 
    private HashMap<Integer, Casa> casas;

    public Controlador(){
        this.utilizadores = new Utilizadores();
        this.casas = new HashMap<>();
    }

    //não precisamos de contrutor parametrizado, o controlador começa sempre vazio e vai "enchendo" conforme o uso da aplicação

    public Controlador(Controlador other){
        this.utilizadores = other.getUtilizadores();
        this.casas = new HashMap<>(other.getCasas());
    }

    public Utilizadores getUtilizadores(){
        return this.utilizadores;
    }

    public HashMap <Integer, Casa> getCasas(){
        return new HashMap<>(this.casas);
    }

    public void setUtilizadores(Utilizadores utilizadores){
        this.utilizadores = utilizadores;
    }

    public void setCasas(HashMap<Integer, Casa> hashMap){
        this.casas = new HashMap<>(hashMap);
    }


    // um pouco confusas de entender mas funcionam
    public void guardaEstado(String ficheiro) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro));
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Controlador carregaEstado(String ficheiro) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro));
            Controlador c = (Controlador) ois.readObject();
            ois.close();
            return c;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Controlador clone(){
        return new Controlador(this);
    }

    public String toString(){
        return "=== Controlador ===\n" +
               "Utilizadores:\n" + this.utilizadores.toString() +
               "Casas (" + this.casas.size() + "):\n";
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Controlador other = (Controlador) o;
        return this.utilizadores.equals(other.utilizadores) &&
               this.casas.equals(other.casas);
    }


}
