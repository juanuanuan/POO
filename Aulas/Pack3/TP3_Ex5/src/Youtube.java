
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Youtube {
    private String nome;
    private int content;
    private LocalDateTime data;
    private String resolucao;
    private ArrayList<String> comentarios;
    private int likes;
    private int dislikes;

    public Youtube(){
        this.nome = "";
        this.content = 0;
        this.data = LocalDateTime.now();
        this.resolucao = "";
        this.comentarios = new ArrayList<>();
        this.likes = 0;
        this.dislikes = 0;
    }

    public Youtube(String nome, int content,LocalDateTime data, String resolucao, ArrayList comentarios, int likes, int dislikes ){
        this.nome = nome;
        this.content = content;
        this.data = data;
        this.resolucao = resolucao;
        this.comentarios = comentarios;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Youtube(Youtube other){
        this.nome = other.getNome();
        this.content = other.getContent();
        this.data = other.getData();
        this.resolucao = other.getResolucao();
        this.comentarios = new ArrayList<>(other.getComentarios());
        this.likes = other.getLikes();
        this.dislikes = other.getDislikes();
    }

    public String getNome() {
        return this.nome;
    }

    public int getContent() {
        return this.content;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public String getResolucao() {
        return this.resolucao;
    }

    public ArrayList getComentarios() {
        return this.comentarios;
    }

    public int getLikes() {
        return this.likes;
    }

    public int getDislikes() {
        return this.dislikes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setComentarios(ArrayList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null && this.getClass() != o.getClass()) return false;
        Youtube other = (Youtube) o;
        return (this.nome == other.nome && this.content == other.content && this.data == other.data &&
                this.resolucao == other.resolucao && this.comentarios == other.comentarios && this.likes == other.likes && this.dislikes == other.dislikes);
    }

    public String toString(){
        return "Nome do vídeo: " + getNome() + "\n" +
                "Conteúdo em bytes: " + getContent() + "\n" +
                "Data de publicação: " + getData() + "\n" +
                "Resolução do vídeo: " + getResolucao() + "\n" +
                "Lista de Comentários: " + getComentarios() + "\n" +
                "Número de Likes: " + getLikes() + "\n" +
                "Número de Dislikes: " + getDislikes() + "\n";
    }

    public Youtube clone(){
        return new Youtube(this);
    }

    public void insereComentario(String coment){
        this.comentarios.add(coment);
    }

    public long diasPassados(){
         return ChronoUnit.DAYS.between(this.data, LocalDateTime.now());
    }

    public void thumbsUp(){
        this.likes += 1;
    }

    public String processa(){
        return this.toString();
    }

    
}
