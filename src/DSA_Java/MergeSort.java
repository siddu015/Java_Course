package DSA_Java;

public class MergeSort {
    public void sort(int[] array) {
        if(array.length < 2) return;

        var middle = array.length / 2;

        int[] left = new int[middle];
        System.arraycopy(array, 0, left, 0, middle);

        int[] right = new int[array.length - middle];
        if (array.length - middle >= 0)
            System.arraycopy(array, middle, right, 0, array.length - middle);

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
