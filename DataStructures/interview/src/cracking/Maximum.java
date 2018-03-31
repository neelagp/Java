package cracking;

/**
 * Created by NeelaGouda on 3/29/18.
 */
public class Maximum {

    /*
    We can modify the standard Binary Search algorithm for the given type of arrays.
i) If the mid element is greater than both of its adjacent elements, then mid is the maximum.
ii) If mid element is greater than its next element and smaller than the previous element then maximum lies on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
iii) If mid element is smaller than its next element and greater than the previous element then maximum lies on right side of mid. Example array: {2, 4, 6, 8, 10, 3, 1}
     */

    public int findMaximum(int arr[],int low, int high){
        if(low == high){
            return arr[low];
        }

        if((high == low +1) && (arr[low] >= arr[high])){
            return arr[low];
        }

        if((high == low +1) && (arr[low] < arr[high])){
            return  arr[high];
        }

        int mid = (low + high) / 2;

        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid +1]){
            return arr[mid];
        }

        if(arr[mid] > arr[mid +1] && arr[mid] < arr[mid -1]){
           return findMaximum(arr, low, mid -1);
        } else{
            return findMaximum(arr, mid +1, high);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 50, 10, 9, 7, 6};
        int n = arr.length;
        Maximum maximum = new Maximum();
        System.out.println("The maximum element is "+
                maximum.findMaximum(arr, 0, n-1));
    }
}
