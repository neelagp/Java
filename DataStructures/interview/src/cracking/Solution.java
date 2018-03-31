package cracking;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude)
    {
        // WRITE YOUR CODE HERE
        // approach split literature text as list of words sperated by space or punctuation
        // read each word ignore case and store as key in hashmap and count as value
        //iterate through hashmap and get all keys with highest value
        String[] words = literatureText.split("[\\p{Punct}\\s]+");
        HashMap<String, Integer> finalCount = new HashMap<String, Integer>();
        for (String word : words) {
            if (!hasExcludedWord(wordsToExclude, word)) {
                if (finalCount.containsKey(word.toLowerCase())) {
                    Integer count = finalCount.get(word.toLowerCase());
                    count = count + 1;
                    finalCount.put(word.toLowerCase(), count);
                } else {
                    finalCount.put(word.toLowerCase(), 1);
                }

            }

        }

        List<String> finalList = new ArrayList<String>();
        Integer maximumCount = Collections.max(finalCount.values());
        for(String word :finalCount.keySet()){
            if(finalCount.get(word).equals(maximumCount)){
                finalList.add(word);
            }
        }

        return finalList;


    }


    // METHOD SIGNATURE ENDS
    private boolean hasExcludedWord(List<String> wordsToExclude, String word) {
        for (String excludedWord : wordsToExclude) {
            if (excludedWord.trim().equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

}
