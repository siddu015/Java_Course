package DSA_Java;

public record Main() {
    public static void main(String[] args) {
       int[] array = {1, 2, 4 ,5, 6, 7};
        var ass = new Search();
        System.out.println(ass.ternarySearchRec(array, 5));
    }

} 
