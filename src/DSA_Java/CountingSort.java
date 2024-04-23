package DSA_Java;

public class CountingSort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1];
        for(var item : array)
            counts[item]++;

        var index = 0;
        for(var i = 0; i < max + 1; i++)
            while(counts[i] > 0) {
                array[index++] = i;
                counts[i]--;
            }
    }

}
