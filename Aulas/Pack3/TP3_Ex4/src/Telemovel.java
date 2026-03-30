import java.util.ArrayList;

public class Telemovel {
    private String marca;
    private String modelo;
    private int displayX;
    private int displayY;
    private int dimensao;
    private double armazenamentoTotal;
    private double armazenamentoFotos;
    private double armazenamentoApp;
    private double espacoOcupado;
    private int fotos;
    private int apps;
    private ArrayList<String> nomeApps;
    private double espacoOcupadoApps; // tive de criar uma nova variável de instância para calcular o tamanho médio das apps. ou era isto ou era criar um HashMap<String,Double> que guardasse tanto o nome das apps como o seu tamanho.

    //Construtor por Omissão
    public Telemovel(){
        this.marca = "";
        this.modelo = "";
        this.displayX = 0;
        this.displayY = 0;
        this.dimensao = 0;
        this.armazenamentoTotal = 0;
        this.armazenamentoFotos = 0;
        this.armazenamentoApp = 0;
        this.espacoOcupado = 0;
        this.fotos = 0;
        this.apps = 0;
        this.nomeApps = new ArrayList<>();
        this.espacoOcupadoApps = 0;
    }
    //Construtor por Parâmetros
    public Telemovel(String marca, String modelo, int displayX, int displayY,
                     int dimensao, double armazenamentoTotal, double armazenamentoFotos, double armazenamentoApp, double espacoOcupado, int fotos, int apps, ArrayList<String> nomeApps, double espacoOcupadoApps ){
        this.marca = marca;
        this.modelo = modelo;
        this.displayX = displayX;
        this.displayY = displayY;
        this.dimensao = dimensao;
        this.armazenamentoTotal = armazenamentoTotal;
        this.armazenamentoFotos = armazenamentoFotos;
        this.armazenamentoApp = armazenamentoApp;
        this.espacoOcupado = espacoOcupado;
        this.fotos = fotos;
        this.apps = apps;
        this.nomeApps = nomeApps;
        this.espacoOcupadoApps = espacoOcupadoApps;
    }

    //Construtor de Cópia
    public Telemovel(Telemovel other){
        this.marca = other.getMarca();
        this.modelo = other.getModelo();
        this.displayX = other.getDisplayX();
        this.displayY = other.getDisplayY();
        this.dimensao = other.getDimensao();
        this.armazenamentoTotal = other.getArmazenamentoTotal();
        this.armazenamentoFotos = other.getArmazenamentoFotos();
        this.armazenamentoApp = other.getArmazenamentoApp();
        this.espacoOcupado = other.getEspacoOcupado();
        this.fotos = other.getFotos();
        this.apps = other.getApps();
        this.nomeApps = new ArrayList<>(other.getNomeApps());
        this.espacoOcupadoApps = other.getEspacoOcupadoApps();
    }

    //Getters e Setters


    public String getMarca() {
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getDisplayX() {
        return this.displayX;
    }

    public int getDisplayY() {
        return this.displayY;
    }

    public int getDimensao() {
        return this.dimensao;
    }

    public double getArmazenamentoTotal() {
        return this.armazenamentoTotal;
    }

    public double getArmazenamentoFotos() {
        return this.armazenamentoFotos;
    }

    public double getArmazenamentoApp() {
        return this.armazenamentoApp;
    }

    public double getEspacoOcupado() {
        return this.espacoOcupado;
    }

    public int getFotos() {
        return this.fotos;
    }

    public int getApps() {
        return this.apps;
    }

    public ArrayList<String> getNomeApps() {
        return this.nomeApps;
    }

    public double getEspacoOcupadoApps() {
        return this.espacoOcupadoApps;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDisplayX(int displayX) {
        this.displayX = displayX;
    }

    public void setDisplayY(int displayY) {
        this.displayY = displayY;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public void setArmazenamentoTotal(double armazenamentoTotal) {
        this.armazenamentoTotal = armazenamentoTotal;
    }

    public void setArmazenamentoFotos(double armazenamentoFotos) {
        this.armazenamentoFotos = armazenamentoFotos;
    }

    public void setArmazenamentoApp(double armazenamentoApp) {
        this.armazenamentoApp = armazenamentoApp;
    }

    public void setEspacoOcupado(double espacoOcupado) {
        this.espacoOcupado = espacoOcupado;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public void setApps(int apps) {
        this.apps = apps;
    }

    public void setNomeApps(ArrayList<String> nomeApps) {
        this.nomeApps = nomeApps;
    }

    public void setEspacoOcupadoApps(double espacoOcupadoApps) {
        this.espacoOcupadoApps = espacoOcupadoApps;
    }

    public Telemovel clone(){
        return new Telemovel(this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Telemovel other = (Telemovel) o;
        return (this.marca == other.marca && this.modelo == other.modelo && this.displayX == other.displayX && this.displayY == other.displayY &&
                this.dimensao == other.dimensao && this.armazenamentoTotal == other.armazenamentoTotal &&
                this.armazenamentoFotos == other.armazenamentoFotos && this.armazenamentoApp == other.armazenamentoApp && this.espacoOcupado == other.espacoOcupado &&
                this.fotos == other.fotos && this.apps == other.apps && this.nomeApps == other.nomeApps);
    }

    public String toString(){
        return "Marca: " + this.marca + "\n" +
                "Modelo: " + this.modelo + "\n" +
                "Resolução X: " + this.displayX + "\n" +
                "Resolução Y: " + this.displayY + "\n" +
                "Dimensão do Texto: " + this.dimensao + "\n" +
                "Dimensão das Fotos das Apps: " + this.armazenamentoTotal + "\n" +
                "Dimensão das Fotos: " + this.armazenamentoFotos + "\n" +
                "Dimensão das Apps: " + this.armazenamentoApp + "\n" +
                "Espaço Ocupado: " + this.espacoOcupado + "\n" +
                "Número de Fotos: " + this.fotos + "\n" +
                "Número de Apps: " + this.apps + "\n" +
                "Apps Instaladas: " + this.nomeApps + "\n" +
                "Espaço Ocupado pelas Aplicações: " + this.espacoOcupadoApps + "\n";
    }

    public boolean existeEspaco(double numeroBytes){
        double espacoLivre = this.armazenamentoTotal - this.espacoOcupado;
        if (espacoLivre < numeroBytes) {
            return false;
        }
        return true;
    }

    public void instalaApp(String nome, double tamanho){
        if(this.existeEspaco(tamanho)){
            this.nomeApps.add(nome);
            this.apps ++;
            this.espacoOcupado += tamanho;
            this.armazenamentoApp -= tamanho;
            this.armazenamentoTotal -= tamanho;
            this.espacoOcupadoApps += tamanho;
        } else{
            System.out.println("Não há espaço para a instalação. Tente libertar memória, desinstalando fotos ou apps.\n");
        }
    }

    public void recebeMsg(String msg){
        if(this.existeEspaco(msg.length())){
            this.dimensao += msg.length();
            this.espacoOcupado += msg.length();
            this.armazenamentoTotal -= msg.length();
        }
    }

    public double tamanhoMedioApps(){
        if(this.apps == 0) return 0;
        return this.espacoOcupadoApps / this.apps;

    }

    public void removeApp(String nome, double tamanho){
        this.nomeApps.remove(nome);
        this.apps --;
        this.espacoOcupado -= tamanho;
        this.espacoOcupadoApps -= tamanho;
        this.armazenamentoApp += tamanho;
        this.armazenamentoTotal += tamanho;

    }


}
