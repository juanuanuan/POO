package Pack2;
import java.time.LocalDateTime;

public class pack2ex2Helper {
    private int[] array; 
    public pack2ex2Helper (int[] array){
        this.array = array;
    }

    public void insereData(int[] data){
        for(int i = 0; i < data.length; i++ ){
            this.array[i] = data[i]; 
        }


    }


    
}
