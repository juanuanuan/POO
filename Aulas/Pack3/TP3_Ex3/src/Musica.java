import java.util.Arrays;

public class Musica {
    private String nome;
    private String interprete;
    private String autor;
    private String editora;
    private String[] letra;
    private String[] musica;
    private double tempo;
    private double views;

    //Construtor por Omissão
    public Musica(){
        this.nome = "";
        this.interprete = "";
        this.autor = "";
        this.editora = "";
        this.letra = new String[0];
        this.musica = new String[0];
        this.tempo = 0;
        this.views = 0;

    }
    //Construtor por Parâmetros
    public Musica (String nome, String interprete, String autor, String editora,
                   String[] letra, String[] musica, double tempo, double views){
        this.nome = nome;
        this.interprete = interprete;
        this.autor = autor;
        this.editora = editora;
        for(int i = 0; i < musica.length; i ++){
            this.musica[i] = musica[i];
        }
        for(int i = 0; i < letra.length; i ++){
            this.letra[i] = letra[i];
        }
        this.tempo = tempo;
        this.views = views;
    }

    public Musica(Musica other){
        this.nome = other.nome;
        this.interprete = other.interprete;
        this.autor = other.autor;
        this.editora = other.editora;
        this.musica = new String[other.musica.length];
        for(int i = 0; i < other.musica.length; i ++){
            this.musica[i] = other.musica[i];
        }
        this.letra = new String[other.letra.length];
        for(int i = 0; i < other.letra.length; i ++){
            this.letra[i] = other.letra[i];
        }
        this.tempo = other.tempo;
        this.views = other.views;
    }

    public String getNome() {
        return this.nome;
    }

    public String getInterprete() {
        return this.interprete;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getEditora() {
        return this.editora;
    }

    public String[] getLetra() {
        return this.letra;
    }

    public String[] getMusica() {
        return this.musica;
    }

    public double getTempo() {
        return this.tempo;
    }

    public double getViews() {
        return this.views;
    }

    public void setNome(String newNome) {
        this.nome = newNome;
    }

    public void setInterprete(String newInterprete){
        this.interprete = newInterprete;
    }

    public void setAutor(String newAutor){
        this.autor = newAutor;
    }

    public void setEditora(String newEditora){
        this.editora = newEditora;
    }

    public void setLetra(String[] newLetra){
        this.letra = newLetra;
    }

    public void setMusica(String[] newMusica){
        this.musica = newMusica;
    }

    public void setTempo(double newTempo){
        this.tempo = newTempo;
    }

    public void setViews(double newViews){
        this.views = newViews;
    }

    public Musica cloneM(){
        return new Musica(this);
    }

    public boolean equalsM(Object o){
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Musica other = (Musica) o;
        return (this.nome == other.nome && this.interprete == other.interprete
                && this.autor == other.autor && this.editora == other.editora && this.letra == other.letra
                && this.musica == other.musica && this.tempo == other.tempo && this.views == other.views);
    }

    public String toString(){
        return "Nome da música: " + getNome() + "\n" +
               "Nome do intérprete: " + getInterprete() + "\n" +
                "Nome do autor: " + getAutor() + "\n" +
                "Editora: " + getEditora() + "\n" +
                "Letra da música: " + Arrays.toString(getLetra()) + "\n" +
                "Notas musicais: " + Arrays.toString(getMusica()) + "\n" +
                "Tempo da música em segundos: " + getTempo() + "\n" +
                "Total de visualizações: " + getViews() + "\n";
    }

    public int qtsLinhasPoema(String[] letra){
        int contador = 0;
        for(int i = 0; i < this.letra.length; i ++){
            contador ++;
        } return contador;
    }

   public int numeroDeCaracteres(String[] letra){
        int total = 0;
        for(String caractere : letra){
              total += caractere.length();
        } return total;
   }











}
