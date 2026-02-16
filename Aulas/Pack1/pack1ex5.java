package Pack1;
import java.util.Scanner;

public class pack1ex5 {
    public static void main(String[] args) {
        double base = 1, altura; 
        double area, perimetro;

        String tipoDeTriangulo;

        Scanner input = new Scanner(System.in);
        while (base != 0) {
            System.out.println("O programa vai calcular a area e o perimetro de um triangulo , dadas a base e a altura."); 
            System.out.println("O programa vai deixar de executar quando a base == 0.");
            System.out.println("Imprima a base.");
            base = input.nextFloat();
            if (base != 0) {
                System.out.println("Introduza o tipo de trinagulo (Is ou Rec ou Equi).");
                tipoDeTriangulo = input.next();
                System.out.println("Imprima a altura.");
                altura = input.nextFloat();
                area = base * altura / 2;
                if (tipoDeTriangulo.equals("Is")) {
                    
                    perimetro = base + 2 + (Math.sqrt(Math.pow(area,2) + Math.pow((base/2),2))); 


                } else if (tipoDeTriangulo.equals("Rec")) {
                    
                    perimetro = base + altura + (Math.sqrt(Math.pow(base,2) + Math.pow(altura,2)));
                } else {
                    
                    perimetro = 3 * base;
                }
            } else {
                System.out.println("Programa Terminado! ");
                continue; 
            } 
            System.out.println("Resultados:");
            System.out.printf("Area: %.2f\n", area);
            System.out.printf("Perimetro: %.2f\n", perimetro);
            System.out.println("Programa Terminado!");
            System.out.println();



        } 
    }
    
}
