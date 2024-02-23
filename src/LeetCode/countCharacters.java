package LeetCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class countCharacters {

    public static void main(String[] args){
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";

       int value = count(words, chars);
       System.out.print(value);
    }
    public static int count(String[] words, String chars) {
        Set <Character> charsSet = new HashSet<Character>();

        int stringCount = 0;
        int count = 0;
        for(String  str : words){
            for(char ch : str.toCharArray()){
                for(int i=0; i < charsSet.size(); i++) {
                    if (ch == chars.charAt(i)) {
                        stringCount++;
                    }
                }
            }

            if(stringCount == str.length())
                count += stringCount;
            stringCount = 0;
        }

        return  count;
    }

}
