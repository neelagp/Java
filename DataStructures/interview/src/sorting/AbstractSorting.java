package sorting;

/**
 * Created by NeelaGouda on 1/30/16.
 */
public abstract class AbstractSorting {

    public  void swap(int j, int minIndex, int[] array) {
        int temp =0;
        temp = array[j];
        array[j] = array[minIndex];
        array[minIndex] = temp;

    }

    public static void printArray(int[] array){
        for(int i : array){
            System.out.println(i);
        }
    }

    public abstract void sort(int[] array);
}
