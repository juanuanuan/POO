package DomusDevice;

public class DomusSoundSystem extends ADomusSimples {

    private int volume; // 0 a 100 
    private String estacao; 

    public DomusSoundSystem(){
        super();
        this.volume = 0; 
        this.estacao = "";
    }

    public DomusSoundSystem(int idObjeto, String marca, String modelo, double consumo, double consumoAtual, int volume, String estacao){
        super(idObjeto, marca, modelo, consumo, Estados.OFF, consumoAtual);
        this.volume = volume; 
        this.estacao = estacao; 
    }

    public DomusSoundSystem (DomusSoundSystem other){
        super(other);
        this.volume = other.getVolume();
        this.estacao = other.getEstacao(); 
    }

    public int getVolume(){
        return this.volume;
    }

    public String getEstacao(){
        return this.estacao; 
    }

    public void setVolume(int volume){
        this.volume = volume; 
    }

    public void setEstacao(String estacao){
        this.estacao = estacao; 
    }

    public DomusSoundSystem clone(){
        return new DomusSoundSystem(this);
    }

    public String toString(){
        return super.toString() + " | Volume: " + getVolume() +
                                  " | Estacao: " + getEstacao();
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusSoundSystem other = (DomusSoundSystem) o;
        return super.equals(o);
    }


    
}
