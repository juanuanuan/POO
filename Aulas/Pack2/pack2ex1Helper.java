package Pack2;

public class pack2ex1Helper {
    private int[] numeros; 
    private int tamanho; 
    public pack2ex1Helper(int[] numeros, int tamanho){ // serve para declarar.
        this.numeros = numeros;
        this.tamanho = tamanho;


    }

    public int minimo(){
        int min = numeros[0];
        for (int i = 0; i < tamanho; i ++){
            if (numeros[i] < min){
                min = numeros[i];
            }
        }return min;
    } 

    public int[] intervalo(int inicio, int fim){
        int range = fim - inicio + 1;
        int[] subarray = new int[range];
        int k = 0;
        for (int i = inicio; i <= fim; i ++){
            subarray[k++] = numeros[i]; 

        } return subarray;
    }

    public int[] comuns(int[] arr1, int[] arr2){
        int[] newarr = new int[Math.min(arr1.length,arr2.length)];
        
        for (int i = 0; i < arr1.length; i ++ ){
            for(int j = 0; j < arr2.length; j ++){
            if(arr1[i] == arr2[j]){
                newarr[i] = arr1[i];
            } 
        }
    } return newarr;
}


    
}
