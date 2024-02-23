package LeetCode;

public class NumberOfMatches {

    public static void main(String args[]){
        int value = numberOfMatches(2);
        System.out.println(value);
    }

    public static int numberOfMatches(int n) {
        int matches = 0;
        if(n == 1) return 0;
        while(n != 1){
            if(n % 2 == 0) {
                n = n/2;
                matches += n ;
            }
            else {
                n = ((n - 1) / 2) + 1;
                matches += n - 1 ;
            }

        }

        return matches;
    }

}
