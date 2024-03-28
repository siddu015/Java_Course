package DSA_Java;

import java.util.Arrays;

public record Main() {
    public static void main(String[] args) {
         var plant = new AVLTree();
         plant.insert(12);
         plant.insert(3);
         plant.insert(9);
         plant.insert(4);
         plant.insert(6);
         plant.insert(2);

        System.out.println();

    }
} 
