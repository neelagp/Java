package cracking;

import java.util.Arrays;

/**
 * Created by NeelaGouda on 5/5/16.
 */
public class Permutation {

    private String baseString = "XXYZY";
    private String permuatationString= "XYZXY";

    private boolean checkIfItsPermuation(){

        if (baseString.length() != permuatationString.length()){
            return false;
        }

        char[] baseChar = baseString.toCharArray();
        Arrays.sort(baseChar);
        String base = new String(baseChar);

        char[] permChar = permuatationString.toCharArray();
        Arrays.sort(permChar);
        String perm = new String(permChar);

        if(base.equals(perm)){
            return true;
        }
        else return  false;

    }

    private boolean checkPermuatation(String t, String s){
        if(t.length() != s.length()) return false;
        int[] letters = new int[128];
        for(char c : t.toCharArray()){
            letters[c]++;
        }

        for(char c : s.toCharArray()){
            int index = (int) c;
            letters[index]--;
            if(letters[index] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Permutation permutation = new Permutation();
        boolean result = permutation.checkPermuatation("XXYYZZ", "XYZXYZ");
        System.out.println(result);
    }

}
