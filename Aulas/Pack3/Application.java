import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinhasEncomenda linha1 = new LinhasEncomenda("REF359", " Dois kilos de massa. ", 10.99f, 2.0f, 6.0f, 0.0f);
        LinhasEncomenda linha2 = new LinhasEncomenda("REF887", " Duzentos kilos de cimento. ", 25.99f, 200.0f, 23.0f, 35.0f);
        LinhasEncomenda linha3 = new LinhasEncomenda("REF204", " Meio kilo de bacalhau. ", 25.0f, 0.5f, 6.0f, 0.0f);
        System.out.println("Bem-vindo ao servico de gestao de encomendas da TransportadoraY.");
        System.out.println("Hoje temos 2 encomendas ativas, fazendo 3 items no total.");
        LinhasEncomenda[] linhasDavid = {linha1,linha3};
        LinhasEncomenda[] linhasConstrucao = {linha2};

        Encomenda encomenda1 = new Encomenda(linhasDavid, "David Mimoso", "Rua dos Agueiros", 330001987, 400300500600L, LocalDate.now());
        Encomenda encomenda2 = new Encomenda(linhasConstrucao, "Cimentos.Lda", "Rua Velha", 290989034, 100100200790L, LocalDate.now());
        System.out.println(encomenda1.toStringA() + "\n" + encomenda2.toStringA());
        int pressione;
        System.out.println("Se deseja ver informacoes adicionais sobre as encomendas, pressione 1.\n");
        pressione = input.nextInt();
        switch(pressione) {
            case 1:

            System.out.println(linha1.toString() + "\n" + linha2.toString() + "\n" + linha3.toString());

            linha1.calculaValorLinhaEnc();
            linha2.calculaValorLinhaEnc();
            linha3.calculaValorLinhaEnc();
            System.out.println("O preco final de cada encomenda e de: \n");

            System.out.println("Encomenda 1: " + String.format("%.2f", linha1.calculaValorLinhaEnc()) + " EUR" + ", com " + String.format("%.2f", linha1.calculaValorDesconto()) + "EUR de desconto por unidade.\n");
            System.out.println("Encomenda 2: " + String.format("%.2f", linha2.calculaValorLinhaEnc()) + " EUR" + ", com " + String.format("%.2f", linha2.calculaValorDesconto()) + "EUR de desconto por unidade.\n");
            System.out.println("Encomenda 3: " + String.format("%.2f", linha3.calculaValorLinhaEnc()) + " EUR" + ", com " + String.format("%.2f", linha3.calculaValorDesconto()) + "EUR de desconto por unidade.\n");
            break;
        }






    }
}