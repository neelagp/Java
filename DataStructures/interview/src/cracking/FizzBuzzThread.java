package cracking;

import java.util.*;

/**
 * Created by NeelaGouda on 5/3/16.
 */
public class FizzBuzzThread extends Thread {

    private static Object lock = new Object();
    protected static int current = 1;
    private int max;
    private boolean div3, div5;
    private String toPrint;


    List<String> retrieveMostFrequentlyUsedWords(String literatureText,
                                                 List<String> wordsToExclude) {
        // WRITE YOUR CODE HERE
        // approach split literature text as list of words sperated by space or punctuation
        // read each word ignore case and store as key in hashmap and count as value
        //iterate through hashmap and get all keys with highest value

        //preprocessing
        Set<String> excludeWordSet = new HashSet<String>(wordsToExclude);
        String[] words = literatureText.split("[\\p{Punct}\\s]+");
        HashMap<String, Integer> finalCount = new HashMap<String, Integer>();

        for (String word : words) {
            if (!hasExcludedWord(excludeWordSet, word)) {
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

        Integer maximumCount = 0;
        if(!finalCount.values().isEmpty()){maximumCount = Collections.max(finalCount.values());}

        for(String word :finalCount.keySet()){
            if(finalCount.get(word).equals(maximumCount)){
                finalList.add(word);
            }
        }

        return finalList;


    }

    private boolean hasExcludedWord(Set<String> wordsToExclude, String word) {
        return wordsToExclude.contains(word);
    }

    public static void main(String[] args) {
        String test ="Rose is a flower red rose are flower";
        List<String> exclude = new ArrayList<String>();
        exclude.add("is");
        exclude.add("are");
        exclude.add("a");
        FizzBuzzThread fb = new FizzBuzzThread();
        fb.retrieveMostFrequentlyUsedWords(test, exclude);

        String s1 = "ab1 aa bb zoo tcg";
        String s2 = "bl22 aa guhy what ever";
        String s3 = "bk2 bb bb cream";
        String s4 = "cs1 558634555";
        String s5 = "bb 22456";
        List<String> loglines = new ArrayList<String>();
        loglines.add(s1);
        loglines.add(s2);
        loglines.add(s3);
        loglines.add(s4);
        loglines.add(s5);
        Set<String> result = fb.reorderLines(5, loglines);
        System.out.println(result);
    }

    public Set<String> reorderLines(int logFileSize, List<String> logLines)
    {
        // WRITE YOUR CODE HERE
        //Iterate through loglines - first word is identifier
        //
        Map<String, String> loglineMapper = new LinkedHashMap<String, String>();
        Map<String, String> numericals = new LinkedHashMap<String, String>();
        Map<String, String> alphabets = new LinkedHashMap<String, String>();
        Map<String, Integer> alphabetAscii = new TreeMap<String, Integer>();
        for(String logline : logLines){
            String identifier = logline.substring(0, logline.indexOf(' '));
            String content = logline.substring(logline.indexOf(' ')+1);
            loglineMapper.put(identifier, content);
        }

        for(Map.Entry<String, String> line : loglineMapper.entrySet()){
            if(line.getValue().matches("[0-9]+")){
                numericals.put(line.getKey(), line.getValue());
            } else{
                alphabets.put(line.getKey(), line.getValue());
            }
        }

        for(Map.Entry<String, String> alphabeticalLines : alphabets.entrySet()){
           char[]  line = alphabeticalLines.getValue().toCharArray();
            int lineascii =0;
            for(char c : line){
                lineascii = lineascii + (int)c;
            }
            alphabetAscii.put(alphabeticalLines.getKey(), lineascii);
        }




        Set<String>  sortedloglines = new LinkedHashSet<String>();
        List<Integer> values = new ArrayList<Integer>(alphabetAscii.values());
        Collections.sort(values);
        for(Integer val : values) {
            for (Map.Entry<String, Integer> entry : alphabetAscii.entrySet()) {
                if(entry.getValue().equals(val))
                sortedloglines.add(entry.getKey() + " " + alphabets.get(entry.getKey()));
            }
        }
        for(Map.Entry<String, String> entry : numericals.entrySet()){
            sortedloglines.add(entry.getKey() + " " +entry.getValue());
        }
       return sortedloglines;

    }


}
