package sorting;

/**
 * compares with element next to it and relatively checks if
 * its smaller or bigger
 * Big O notation , Worst Case: O(n2)and Best Case is O(n)
 */
public class InsertionSort extends AbstractSorting{

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {13, 23, 45, 2, 4, 5, 7};
        insertionSort.sort(array);
        printArray(array);

    }

    @Override
    public void sort(int[] array) {

        int currIndex = 0;
        for (int i= 1; i< array.length; i++){
            currIndex = i;

            while(currIndex > 0 && array[currIndex -1] > array[currIndex]){
                swap(currIndex,currIndex-1, array);
                currIndex = currIndex -1;
            }
        }

    }
}
