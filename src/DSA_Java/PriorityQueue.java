package DSA_Java;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
    private int  size;

    public void add(int item){
        if(isFull())
            throw new IllegalStateException();

        var i = shiftItemsToInsert(item);
        items[i] = item;
        size++;
    }

    public int remove(){
        if(isEmpty())
        throw new IllegalStateException();
        return items[--size];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == items.length;
    }
    
    private int shiftItemsToInsert(int item) {
        int i;
        for(i = size - 1; i>=0; i--){
            if(items[i] > item)
                items[i+1] = items[i];
            else 
                break;
        }
        return i + 1;
    }
    
    @Override
    public String toString(){
        var content = Arrays.copyOfRange(items, 0, size);
        return Arrays.toString(content);
    }
}
