package cracking;

/**
 * Created by NeelaGouda on 5/9/16.
 */
public class PalindromePermutation {

    private boolean checkIfPalindromePermutation(String phrase) {
        //palindrome permutation - we know all characters should have even count and exactly one can have odd count

        int[] table = getLetterTable(phrase);
        return checkMaxOneOdd(table);

    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;

            }
        }

        return true;
    }

    private int[] getLetterTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);

            if (x != 1) {
                table[x]++;
            }
        }

        return table;


    }

    private int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        if (a <= val && val <= z) {
            return val - a;
        }

        return -1;

    }

    public static void main(String[] args) {
        PalindromePermutation pp = new PalindromePermutation();
        Boolean result = pp.checkIfPalindromePermutation("abcdcba");
        System.out.println(result);
    }
}
