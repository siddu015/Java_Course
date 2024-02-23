package DSA_Java;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Expression {

    private String input;
    private final List<Character> openBrackets =  Arrays.asList('(', '{', '[', '<');
    private final List<Character> closeBrackets = Arrays.asList(')', '}', ']', '>');

    public Expression(String input){
        this.input = input;
    }

    public boolean isBalanced(){
        Stack<Character> stack = new Stack<>();

        for (Character ch :input.toCharArray() ) {
            if(checkOpenBrackets(ch)) 
                stack.push(ch);

            if(checkCloseBrackets(ch)){
                if(stack.empty()) return false;
                
                char top = stack.pop();
                if(!matchBrackets(top, ch)) return false;
            }
            
        }
        return stack.empty();
    }

    private boolean matchBrackets(Character open, char close) {     
        return openBrackets.indexOf(open) == closeBrackets.indexOf(close);
    }

    private boolean checkOpenBrackets(Character ch) { 
        return openBrackets.contains(ch);
    }

    private boolean checkCloseBrackets(Character ch) {
        return closeBrackets.contains(ch);
    }
        
}
