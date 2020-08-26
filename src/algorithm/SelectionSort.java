package algorithm;

/**
 * regur
 * 2020-02-04
 * 오후 5:05
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {65,10,1,99,5};
        sort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.println("data["+i+"]"+data[i]);
        }

    }

    public static void sort(int[] data){
        int size = data.length;
        int min;
        int temp;


        for (int i = 0; i < size-1; i++) {
            min = i;
            for (int j = i+1; j < size ; j++) {
                if(data[min] > data[j]){
                    min = j;
                }
                temp = data[min];
                data[min] = data[i];
                data[i] = temp;
            }
        }

    }
}
