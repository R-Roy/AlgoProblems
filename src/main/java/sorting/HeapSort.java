package sorting;

import utility.ArrayUtility;

public class HeapSort {

    int[] array = new int[128];
    static int  count = 0;

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();

        ArrayUtility.fillRandoms(sort.array); //fills array with random integer
        ArrayUtility.printArray(sort.array, "intial print count:"+ count); // print your message first in next line it prints all the array members
        sort.sort();
        ArrayUtility.printArray(sort.array, " final print count: "+ count);

        System.out.println("\n\n====\n\n"+ count);
    }

    void sort() {

        //build heap array first
        for (int i = 0; i < array.length / 2; i++) {
            heapify(array, i, array.length );
        }

        ArrayUtility.printArray(array, " print after heapify, before deletion count "+ count);

        //now start deleting with last node exchange
        for( int i = array.length -1; i > 0; i-- ){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i -1);
            ArrayUtility.printArray(array, " print after heapifying of each element deletion count "+ count);
        }
    }

    void heapify(int[] array, int indexToHeapify, int length) {
        int left = (2 * indexToHeapify) + 1;
        int right = 2 * (indexToHeapify + 1);

        //heapify left

        if (left <= length-1 && array[left] > array[indexToHeapify]) {
            //swap with left
            int temp = array[left];
            array[left] = array[indexToHeapify];
            array[indexToHeapify] = temp;
            count +=3;
            heapify(array, left, length);

        }

        //heapify right


        if (right <= length-1 && array[right] > array[indexToHeapify]) {
            //swap with right
            int temp = array[right];
            array[right] = array[indexToHeapify];
            array[indexToHeapify] = temp;
            count +=3;
            heapify(array, right, length);
        }



    }
}
