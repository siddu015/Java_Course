package LeetCode;
import java.util.Arrays;

public class Piles {

    public static int getCoins(int[] piles) {
        Arrays.sort(piles);
        
        int arrayLength = piles.length;
        int coins = 0;


        for(int i = arrayLength / 3; i < arrayLength; i += 2)
            coins +=  piles[i];

        return coins;
    }



}
