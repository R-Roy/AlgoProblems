package sorting;

import utility.ArrayUtility;

import java.util.Arrays;

public class MergeSort {

    static int count = 0;
    int[] array = new int[128];
    int[] bufferArray = new int[128];

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();

        ArrayUtility.fillRandoms(sort.array); //fills array with random integer

        int[] tempCopy = Arrays.copyOf(sort.array, 128);
        Arrays.sort(tempCopy);

        ArrayUtility.printArray(sort.array, "intial print count:" + count); // print your message first in next line it prints all the array members
        sort.sort();
        ArrayUtility.printArray(sort.array, " final print count: " + count);


        System.out.println("\n\n====\n\n" + count + " \n \n \n ====" + Arrays.equals(tempCopy, sort.array));
    }


    public void sort() {

        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int startIndex, int endIndex) {


        if (startIndex >= endIndex) {
            //single member array
           // finalArray[startIndex] = array[startIndex];
            return;
        }

        if (startIndex == endIndex - 1) { // 2 member array
            //smaller number in beginning
            if (array[startIndex] > array[endIndex]) {
                int temp = array[startIndex];
                array[startIndex] = array[endIndex];
                array[endIndex] = temp;


                /* finalArray[startIndex] = array[startIndex];
                finalArray[endIndex] = array[endIndex];*/
                count ++;
            }
            return;
        }

        //more than 2 members so split
        int middle = (startIndex + endIndex) / 2;

        // split in 2 halves
        mergeSort(array, startIndex, middle);
        mergeSort(array, middle+1 , endIndex);

        //once halves are sorted then merge both halve
       mergeTwoParts(array, startIndex, middle, endIndex);
    }

    private void mergeTwoParts(int[] array, int startIndex, int middle, int endIndex) {
        int index1  =startIndex;
        int index2 = middle+1;

        //Now merge in middle
        for (int i = index1; index2 <= endIndex && index1 <= middle && i <= endIndex; i++) {
            // so if we have merged from both the array the control won't come inside

            //  see which array has the smaller element merge from it
            if (array[index1] < array[index2]) {
                bufferArray[i] = array[index1++];
                count++;
            } else {
                bufferArray[i] = array[index2++];
                count++;
            }
        }
        //copy from array 1
        if( index1 <= middle) {
            for (int i = index1; i <= middle; i++) {
                bufferArray[i] = array[index1++];
            }
        }
        //copy from array 2
      else  if( index2 <= endIndex) {
            for (int i = index2; i <= endIndex; i++) {
                bufferArray[i] = array[index2++];
            }
        }

        //now copy the final array back to main array so that the combined array available for next merging, has the sorted item
        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = bufferArray[i];
        }
    }
}
