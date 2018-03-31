package sorting;

/**
 * select the smallest element and swap it in the right place
 * Big O notation Worst Case: O(n2), Best Case: O(n)
 */
public class SelectionSort extends AbstractSorting{

    public void sort(int[] array){
        int minIndex =0;
        for (int i=0;i<array.length; i++){
            minIndex = i;
            for(int j= i+1; j<array.length; j++){
                //change this to > to sort in decreasing order
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(i,minIndex, array);
        }
    }



    public static void main(String[] args) {
        int[] array = {1, 7, 3, 5, 9, 22, 4, 5};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
        printArray(array);
    }
}
