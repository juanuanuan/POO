import java.util.Scanner;

public class ApplicationCirculo{
    public static void main(String[] args){
        Circulo circleDefault = new Circulo();
        Circulo circleParam = new Circulo(2,4,3);
        Circulo circleCopy = new Circulo (circleParam);
        System.out.println(circleParam.equalsC(circleCopy));
        System.out.println(circleDefault.toString());
        System.out.println(circleParam.toString());
        System.out.println(circleCopy.toString());
        circleParam.setX(6);
        circleCopy.setY(4);
        circleDefault.setRaio(4);
        System.out.println(circleDefault.getRaio());
        System.out.println(circleParam.getY());
        System.out.println(circleCopy.getRaio());
        System.out.println("Como podemos observar, houve mudança nas variáveis de instância.\n");
        circleCopy.alteraCentro(9,9);
        System.out.println(circleCopy.toString());
        System.out.println("Mais uma vez, houve alteração.\n");
        Circulo novoC = circleCopy.cloneC();
        novoC.alteraCentro(4,4);
        System.out.println(novoC.toString());
        novoC.setRaio(5);
        double area = novoC.areaCirculo(novoC.getRaio());
        double perimetro = novoC.calculaPerimetro(novoC.getRaio());
        System.out.println("A área do círculo clonado através de circleCopy é: " + area);
        System.out.println("O perímetro do círculo clonado através de circleCopy é: " + perimetro);






    }
}