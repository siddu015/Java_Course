package DSA_Java;
import java.util.*;

public class LinkedList{

    private class Node{
        private int value;
        private Node next;
        
        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last; 
    private int size;
    
    public Node getPrevious(Node node){
        var second = first;
        while(second != null){
           if(second.next == node)  return second;
           second = second.next;
        }
        return null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void addLast(int item){
        var node = new Node(item);

        if (isEmpty())   
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
        size++;

    }

    public void addFirst(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public int indexof(int item){
        int index = 0;
        var current = first;
        while(current != null){
            if(current.value == item)    return index;
            current = current.next;
            index++;
        }
        return -1;   
    }

    public boolean contains(int item){
        return indexof(item) != -1;
    }

    public void deleteFirst(){
        //[1 1(2)->3] second = 2 
        if(isEmpty())
            throw new NoSuchElementException();
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void deleteLast(){
        //[1->2 3] 
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            size--;
            return ;
        }
        var current = getPrevious(last);
        current.next = null;
        last = current;
        size--;     
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        for(int i=0;i<size;i++){
            array[i]=current.value;
            current = current.next;
        }
        return array;
    }

    public void reverse(){
        if(isEmpty()) return;
        var previous = first;
        var current = first.next;
        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;     
        // var back = last;
        // var current = getPrevious(last);
        // while (current != null) {
        //     var next = getPrevious(current);
        //     back.next = current;
        //     back = current;
        //     current = next;
        // }
        // first = last;
        // last = back;
        // last.next = null;

    }

    public int getKthFromTheEnd(int k){
        if(k<1 || k>size) throw new IllegalArgumentException();
        // int i=1;
        // var current = last;
        // while(i != k){
        //     current = getPrevious(current);
        //     i++;
        // }
        // System.out.println("Element at "+k+" from the end is: "+current.value);
        var a = first;
        var b = first;
        for(int i=0;i<k-1;i++) b = b.next;
        while(b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void printMiddle(){                
        // var a = first;
        // var b = first;
        // int i=0;
        // while(b != null){
        //     b = b.next;
        //     i++; 
        // }
        // if(i%2 ==0){
        //     for(int j=1;j<i/2;j++) a = a.next;//a =1 then j=1 a=2, j=2 a=3,j=3
        //     System.out.print("The middle Terms are :"+a.value+","+a.next.value);
        // }
        // else{
        //     for(int j=0;j<i/2;j++) a = a.next; // a=1 then j=0 a=2 , j=1 a=3; j=2 a=4;j=3
        //     System.out.println("The middle Term is :"+a.value);
        // }
            var a = first;
            var b = first;
            while(b != last && b.next != last){
                b = b.next.next; 
                a = a.next;
            }
            if(b == last)   System.out.println(a.value);
            else            System.out.println(a.value + " and " + a.next.value);
    }

    public void hasLoop(){
        //[10->29->30->40->50->60]
        //              a           b 
        //
        var slow = first;
        var fast = first;
        int check = 1;
        while(fast != null){
            slow = slow.next;
            fast = fast.next.next;
            check++;
            if(check == size){
                System.out.println("Loop Exists");
                return;
            }
        }
        System.out.println("No Loop Exists");
    }
}

