package Pack2;

import java.util.Arrays;

public class dupsp2e4 {
    public String[] semRepeticoes(String[] a){
        String [] unicos = new String[a.length];
        int n = 0;
        for (int i = 0; i < a.length; i ++){
            boolean unico = true;
            for (int j = 0; j < unicos.length; j ++){
                if (a[i].equals(unicos[j])){
                    unico = false;
                    break;  
            } 

            } if (unico){
                unicos[n] = a[i];
                n++;
        }
    } return Arrays.copyOf(unicos,n);
    
 }
}
