package DSA_Java;

import java.util.Arrays;

//check
public class ArrayDeque {

    private int[] items;
    private int size;
    private int rear;
    private int front;

    public ArrayDeque(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int value){
        if(items.length == size )
            throw new IllegalStateException();

        items[rear] = value; 
        rear = (rear + 1) % items.length;

        size++;
    }

    public int dequeue(){
        if(size == 0)
            throw new IllegalArgumentException();

        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        size--;

        return item;
    }
    
    public int peek(){
        if(size == 0)
            throw new IllegalArgumentException();
        return items[0];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == items.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
