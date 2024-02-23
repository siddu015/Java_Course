package DSA_Java;

import java.util.Stack;


public class ReverseString {

    public String reverse(String input) {
        if(input == null)
            throw new IllegalArgumentException("String cannot be null");

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray())
            stack.push(ch);
        
        StringBuffer output = new StringBuffer();
        while (!stack.isEmpty()) 
            output.append(stack.pop());
             
        return output.toString();
    }


    
}
