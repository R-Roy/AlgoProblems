package sorting;

import utility.ArrayUtility;

import java.util.Arrays;

public class HeapSort {

    int[] array = new int[128];
    static int  count = 0;

    public static void main(String[] args) {
        HeapSort sort = new HeapSort();

        ArrayUtility.fillRandoms(sort.array); //fills array with random integer

        //amking one extra copy to evaluate the resu;t
        int [] copy = Arrays.copyOf(sort.array,sort.array.length);

        ArrayUtility.printArray(sort.array, "intial print count:"+ count); // print your message first in next line it prints all the array members
        sort.sort();
        ArrayUtility.printArray(sort.array, " final print count: "+ count);
        //now doing a java's default sort and finding if my results are good or not
        Arrays.sort(copy);

        System.out.println("\n\n====\n\n"+ count+"\n\n\n====="+Arrays.equals(sort.array, copy));
    }

    void sort() {

        //build heap array first
        for (int i = array.length-1; i >= 0; i--) {
            heapify(array, i, array.length-1 );
        }

        ArrayUtility.printArray(array, " print after heapify, before deletion count "+ count);

        //now start deleting with last node exchange
        for( int i = array.length -1; i >= 0; i-- ){
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
        if (left <= length && array[left] > array[indexToHeapify]) {
            //swap with left
            int temp = array[left];
            array[left] = array[indexToHeapify];
            array[indexToHeapify] = temp;
            count +=3;
            heapify(array, left, length);

        }

        //heapify right
        if (right <= length && array[right] > array[indexToHeapify]) {
            //swap with right
            int temp = array[right];
            array[right] = array[indexToHeapify];
            array[indexToHeapify] = temp;
            count +=3;
            heapify(array, right, length);
        }



    }
}
