package LeetCode;

import DSA_Java.Array;

public class EqualSting {
   public static void main(String[] args) {
    String[] s1 = {"ab","c"};
    String[] s2 = {"a","bc"};
    boolean value = arrayStringsAreEqual(s1, s2);
    System.out.println(value);

   }

   public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        String s1 = "";
        String s2 = "";

        for(String string : word1)
            s1 += string;

        for(String string : word2)
            s2 += string;
        
        return s1.equals(s2);
   }
}
