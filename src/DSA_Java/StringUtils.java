package DSA_Java;

import java.util.*;

public class StringUtils {
    public int countVowels(String str) {
        if(str == null) return 0;

        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        return (int) str.chars().mapToObj(c -> (char) c).filter(vowels::contains).count();
    }

    public String reverse(String str) {
        if(str == null) return "";

        StringBuilder reversed = new StringBuilder();
        for(var c: str.toCharArray())
            reversed.insert(0, c);
        return reversed.toString();
    }

    public String reverseWords(String sentence) {
        if(sentence == null) return "";

        String[] words = sentence.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public boolean rotation(String str1, String str2) {
        if(str1 == null || str2 == null) return false;

        return str1.length() == str2.length()
                && (str1 + str1).contains(str2);
    }

    public String removeDuplicates(String str) {
        if(str == null) return "";

        Set<Character> seen = new HashSet<>();

        StringBuilder result = new StringBuilder();
        for(var c: str.toCharArray())
            if(!seen.contains(c)) {
                result.append(c);
                seen.add(c);
            }

        return result.toString();
    }

    public Character getMaxOccurringChar(String str) {
        if(str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCII_SIZE = 256;
        int[] frequencies = new int[ASCII_SIZE];
        for(var c: str.toCharArray())
            frequencies[c]++;

        int max = 0;
        char result = ' ';
        for(var i = 0; i < frequencies.length; i++)
            if(frequencies[i] > max) {
                max = frequencies[i];
                result = (char) i;
            }

        return result;
    }

    public String capitalize(String sentence) {
        if(sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence
                            .trim()
                            .replaceAll(" +"," ")
                            .split(" ");

        for(var i = 0; i < words.length; i++)
            words[i] =
                    words[i].substring(0, 1).toUpperCase() +
                    words[i].substring(1).toLowerCase();

        return String.join(" ", words);
    }

    public boolean areAnagrams(String first, String second) {
        if(first == null || second == null
            || first.length() != second.length())
            return false;

        var array1 = first.toLowerCase().toCharArray();
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public boolean isPalindrome(String word) {
        if(word == null)
            return false;

        var left = 0;
        var right = word.length() - 1;
        while (left < right)
            if(word.charAt(left++) != word.charAt(right--))
                return false;

        return true;
    }
}
