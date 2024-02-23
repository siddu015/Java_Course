package LeetCode;
import java.util.Arrays;

public class Arthematic {
    public boolean[] checkArithmetic(int[] nums, int[] l, int[] r) {
        int sizeofIndexArray = l.length ;
        boolean[] result = new boolean[sizeofIndexArray];

        for(int i=0; i<sizeofIndexArray; i++){

            int sizeOfSubArray = r[i] - l[i] + 1;
            int[] subArray = Arrays.copyOfRange(nums, l[i], r[i] + 1);

            Arrays.sort(subArray);
       
            int[] difference = new int[sizeOfSubArray - 1];            
            for(int p =0; p < sizeOfSubArray - 1; p++) //storing differences in differnce array
                difference[p] = subArray[p] - subArray[p+1];
         
            result[i] = checkAllElementsAreSame(difference);
        }
        return result;
    }

    private boolean checkAllElementsAreSame(int[] array){
        for(int i=0; i < array.length - 1; i++){
            if(array[i] != array[i+1]) return false;
        }
        return true;
    }


}

