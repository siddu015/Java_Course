package DSA_Java;


public record Main() {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4 , 1, 2};
        System.out.println(MaxHeap.getKthLargest(arr, 5));
//        System.out.println(Arrays.toString(arr));
    }
} 
