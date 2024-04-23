package DSA_Java;


import java.util.Arrays;

public record Main() {
    public static void main(String[] args) {
       int[] array = {5, 3, 2, 1};
        var ass = new BucketSort();
        ass.sort(array, 5);
        System.out.println(Arrays.toString(array));
    }

} 
