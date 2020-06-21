package leet;

import java.util.HashMap;
import java.util.Map;

public class WordsToNumber {

    Map<String, Integer> smallNums = new HashMap<String, Integer>(){{
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
        put("ten", 10);
        put("eleven", 11);
        put("twelve", 12);
        put("thirteen", 13);
        put("fourteen", 14);
        put("fifteen", 15);
        put("sixteen", 16);
        put("seventeen", 17);
        put("eighteen", 18);
        put("nineteen", 19);
        put("twenty", 20);
        put("thirty", 30);
        put("forty", 40);
        put("fifty", 50);
        put("sixty", 60);
        put("seventy", 70);
        put("eighty", 80);
        put("ninety", 90);
    }};

    Map<String, Integer> bigNums = new HashMap<String, Integer>(){{
        put("thousand", 1000);
        put("million", 1000000);
    }};

    public int convert(String words) {
        String[] tokens = words.split("\\s+");

        int tempNum = 0;
        int finalNum = 0;

        for(String w: tokens) {
            if (smallNums.containsKey(w)) {
                tempNum += smallNums.get(w);
            } else if (w.equals("hundred")) {
                tempNum  *= 100;
            } else if (bigNums.containsKey(w)) {
                tempNum *= bigNums.get(w);
                finalNum += tempNum;
                tempNum = 0;
            }
        }

        finalNum += tempNum;

        return finalNum;
    }

    public static void main(String[] args) {
        WordsToNumber w = new WordsToNumber();
        System.out.println(w.convert("nine"));
        System.out.println(w.convert("eighty four"));
        System.out.println(w.convert("four hundred and eighty four"));
        System.out.println(w.convert("five hundred thousand four hundred and twenty one"));
        System.out.println(w.convert("three hundred million and forty four"));
    }

}
