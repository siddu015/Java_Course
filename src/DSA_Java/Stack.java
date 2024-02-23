package DSA_Java;

import java.util.Arrays;

public class Stack {
    private int size;
    private int[] stack;
    
    public Stack(int capcaity) {
        stack = new int[capcaity];
    }

    public void push(int item){
        if(size == stack.length)
            throw new StackOverflowError();
        stack[size++] = item;           
    }

    public int pop(){
        if(size == 0)
            throw new IllegalStateException(" ");
        return stack[size--];
    }

    public int peek(){
        if(size == 0)
            throw new IllegalStateException(); 
        return stack[size - 1];
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0 , size);
        return Arrays.toString(content);


    }
}
