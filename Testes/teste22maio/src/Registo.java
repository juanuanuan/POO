import java.io.Serializable;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;

public class Registo implements Comparable<Registo>, Serializable {
    private LocalDate inicio;
    private LocalDate fim;
    private int idUser;
    private int dinheiroGasto;


    public Registo(){
        this.inicio = LocalDate.now();
        this.fim = LocalDate.now(); // como é por omissão, as datas são iguais
        this.idUser = -1;
    }

    // classe muito incompleta (assim como as outras) mas serve para o teste

    public Registo(LocalDate inicio, LocalDate fim, int idUser){
        this.inicio = inicio;
        this.fim = fim;
        this.idUser = idUser;
    }

    @Override
    public int compareTo(Registo o) {
        return Integer.compare(this.idUser, o.idUser);
    }
}
