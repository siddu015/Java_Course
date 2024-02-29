public class Factorial {
    public static void main(String[] args) {
        long n = 20;

        long result = factorial(n);

        System.out.println(result);
        System.out.println(trailingZeros(result));
    }

    static long factorial(long n){
        long r = 1;
        for(long i = n; i > 0; i--)
             r = r * i;

        return r;
    }

    static long trailingZeros(long factorial){
        long result =0;
        for(long i = factorial; i>0; i = i/10){
            if(i % 10 == 0)
                result++;
            else
                break;
        }
        return result;
    }
}
