import java.util.HashMap;
import java.util.zip.Inflater;

/**
 * Created by NeelaGouda on 4/2/16.
 */
public class IsUnique {

    public static void main(String[] args) {
        String nonUnique = "TWXYVN";
        String unique = "TTWWXXXNN";

        IsUnique isUnique = new IsUnique();

        System.out.println("Element is unique from DS" + isUnique.checkIfItsUniqueUsingDS(unique));

        System.out.println("Element is unique from NON DS" + isUnique.checkIfItsUniqueWithNoDS(nonUnique));

        System.out.println("Element is unique from NON DS" + isUnique.checkIfItsUniqueAscii(nonUnique));


    }

    //Here the time complexity is O(n2)
    private  boolean checkIfItsUniqueWithNoDS(String nonUnique) {

        char[] nonUniqueArray = nonUnique.toCharArray();
        int i =0 ;
        int j =0 ;
        for(i=0; i < nonUniqueArray.length; i++){
            for (j = i+1 ; j< nonUniqueArray.length; j++){
                if(nonUniqueArray[i] == nonUniqueArray[j]){
                    return false;
                }
            }
        }

        return true;

    }
//Here the time complexity is O(n)
    private  boolean checkIfItsUniqueUsingDS(String nonUnique) {
        char[] nonUniqueArray = nonUnique.toCharArray();

        HashMap<Character,Integer> redMap = new HashMap<Character, Integer>();

        for(char c : nonUniqueArray){

            if(!redMap.containsKey(c)){
                redMap.put(c,1);
            }
            else return false;

        }

        return true;

    }

    //time complexity is 0(1)
    private boolean checkIfItsUniqueAscii(String unique){
        if(unique.length() > 128){
            return false;
        }

        boolean[] charArray = new boolean[128];

        for (int i =0 ; i < 128 ; i++){
            int val = unique.charAt(i);
            if(charArray[val]){
                return false;
            }
            else return  true;

        }

        return true;
    }
}
