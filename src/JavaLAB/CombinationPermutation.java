package JavaLAB;

import java.util.Scanner;

public class CombinationPermutation {
    public static int factorial(int n){
        if(n == 0 || n == 1)
            return  1;
        else
            return n * factorial(n-1);
    }

    public static int nCr(int n, int r){
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static int nPr(int n, int r){
        return factorial(n) / factorial(n - r);
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("1.For ncr\n2.For npr\nEnter value: ");
        int value = scanner.nextInt();
        System.out.print("Enter n:");
        int n = scanner.nextInt();
        System.out.print("Enter r:");
        int r = scanner.nextInt();

        switch (value){
            case 1:
                if(n >= r)
                    System.out.println("nCr: "+nCr(n,r));
                else
                    System.out.println("Invalid inputs");
                break;
            case 2:
                if(n >= r)
                    System.out.println("nPr: "+nPr(n,r));
                else
                    System.out.println("Invalid inputs");
                break;
            default:
                System.out.println("Invalid entry.");
        }

    }

}
