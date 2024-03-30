package DSA_Java;

public class MaxHeap {
    public static void heapify(int[] array) {
        var largestParentIndex = array.length / 2 - 1;
        for(int i = largestParentIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static int getKthLargest(int[] array, int k) {
        var heap = new Heap();
        for(var item: array)
            heap.insert(item);

        for(int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = (index * 2) + 1;
        if (leftIndex < array.length &&
            array[leftIndex] > array[largerIndex])
          largerIndex = leftIndex;

        var rightIndex = (index * 2) + 2;
        if (rightIndex < array.length  &&
            array[rightIndex] > array[largerIndex])
          largerIndex = rightIndex;

        if(index == largerIndex)
            return;

        Swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void Swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
