package Domus;

import java.io.Serializable;
import java.util.HashMap;

public class Casas implements Serializable {
    private HashMap<Integer, Casa> casas;

    public Casas(){
        this.casas = new HashMap<>();
    }

    public Casas (HashMap<Integer, Casa> casas){
        this.casas = new HashMap<>();
        casas.forEach((id, c) -> this.casas.put(id, c.clone()));
    }

    public Casas (Casas other){
        this.casas = new HashMap<>();
        other.casas.forEach((id,c) -> this.casas.put(id, c.clone()));
    }

    public HashMap<Integer, Casa> getCasas() {
        HashMap<Integer, Casa> copia = new HashMap<>();
        this.casas.forEach((id,c) -> copia.put(id, c.clone()));
        return copia;
    }

    public void setCasas(HashMap<Integer, Casa> casas) {
        this.casas = new HashMap<>();
        casas.forEach((id,c) -> this.casas.put(id, c.clone()));
    }

    public Casas clone(){
        return new Casas(this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Casas other = (Casas) o;
        return (this.casas.equals(other.casas));
    }




    //FIXME: colocar aqui os metodos que retornam casas.
}
