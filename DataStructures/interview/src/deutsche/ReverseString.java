package deutsche;

/**
 * Created by NeelaGouda on 5/15/16.
 */
public class ReverseString {

    public static void main(String[] args) {
        String toReverse = "This string needs to be reversed";

        char[] charArray = toReverse.toCharArray();
        ReverseString reverseString = new ReverseString();
        String reverse = reverseString.reverseString(charArray);
        System.out.println(reverse);

    }

    public String reverseString(char[] charArray){

        int n = charArray.length;
        int halfLength = n/2;

        for(int i=0; i<halfLength; i++){

            char temp = charArray[n-1-i];
            charArray[n-1-i] = charArray[i];
            charArray[i] = temp;


        }

       String reverseString = String.valueOf(charArray);
        return reverseString;

    }
}
