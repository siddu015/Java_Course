package JavaLAB;

import java.util.Scanner;

public class Sparse {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

        var matrix = new int[rows][columns];
        System.out.print("Enter elements in the matrix:");
        for(int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = scanner.nextInt();

        int count =0, sum =0;
        int size = rows * columns;
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0)
                    count++;
                else
                    sum += matrix[i][j];
            }
        }

        if(count > (size / 2))
            System.out.println("It's a sparse matrix and sum is :"+ sum);
        else
            System.out.println("It is not a sparse matrix.");
    }
}


