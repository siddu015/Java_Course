public class Main {
    public static void main(String[] args) {
        int n = 25;

        System.out.println(sqr_root(n));

    }

    static int sqr_root(int n) {
        int low = 0, mid, high = n;

        while (true) {
            mid = (low + high)/2;

            if( Math.pow(mid, 2) <= n && Math.pow(mid+1, 2) > n) {
                return mid;
            }

            if(Math.pow(mid, 2) < n)
                low = mid;
            else
                high = mid;

        }

    }
}

