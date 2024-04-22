package DSA_Java;


import java.util.Arrays;

public record Main() {
    public static void main(String[] args) {
        int[] arr = {};
        var sort = new BubbleSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
} 
