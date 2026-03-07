public class TP2_Ex3Helper {
    private int[] array;
    public TP2_Ex3Helper(int[] array){
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    public int[] bbsort(int[] arr){
        for(int i = 0; i < arr.length - 1; i ++){
            for(int j = 0; j < arr.length - i - 1; j ++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        } return arr;
    }

    public int binaryS(int[] arr, int alvo){
        int inicio = 0;
        int fim = arr.length -1;
        while (inicio <= fim){
                    int middle = (inicio + fim) / 2;
                    if(arr[middle] == alvo){
                        return middle;
                    } else if (arr[middle] < alvo) {
                        inicio = middle + 1;
                    } else {
                        fim = middle - 1;
                    }
                }return -1;
        }



}

