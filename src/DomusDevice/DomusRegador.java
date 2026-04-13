package DomusDevice;

public class DomusRegador extends DomusAbstract{

    private int fluxoAgua;
    private int duracaoMinutos; 

    public DomusRegador(){
        super();
        this.fluxoAgua = 0; 
        this.duracaoMinutos = 0; 
    }

    public DomusRegador(int idObjeto, String marca, String modelo, double consumo, int fluxoAgua, int duracaoMinutos){
        super(idObjeto, marca, modelo, consumo, Estado.OFF);
        this.fluxoAgua = fluxoAgua;
        this.duracaoMinutos = duracaoMinutos; 
    }
   
    public DomusRegador(DomusRegador other){
        super(other);
        this.fluxoAgua = other.getFluxoAgua(); 
        this.duracaoMinutos = other.getDuracaoMinutos();
    }

    //getters e setters 

    public int getFluxoAgua(){
        return this.fluxoAgua;
    }

    public int getDuracaoMinutos(){
        return this.duracaoMinutos;
    }

    public void setFluxoAgua(int fluxoAgua){
        this.fluxoAgua = fluxoAgua; 
    }

    public void setDuracaoMinutos(int duracaoMinutos){
        this.duracaoMinutos = duracaoMinutos;
    }

    public DomusRegador clone(){
        return new DomusRegador(this);
    }

    public String toString(){
        String result = super.toString() + " | fluxo de agua: " + this.fluxoAgua +
                                           " | duracao em minutos: " + this.duracaoMinutos;
        return result;                                  
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        DomusRegador other = (DomusRegador) o;
        return super.equals(o) && this.fluxoAgua == other.getFluxoAgua();
    }
    
} 




   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    /* public void ligaObj(){
        super.setestadoAtual(Estado.ON);
    }

    public void desligaObj(){
        super.setestadoAtual(Estado.OFF);
    }

    public DomusRegador(){
        super();
    }

    public DomusRegador(DomusRegador other){
        super(other);
    }

    public DomusRegador clone(){
        return new DomusRegador(this);
    } */






