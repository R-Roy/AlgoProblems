package sorting;

import utility.ArrayUtility;

public class MergeSort {

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


    public void sort(){

        mergeSort(array, 0, array.length-1);
    }

    private int [] mergeSort(int[] array, int startIndex, int endIndex) {

        if( startIndex >= endIndex){
            //single member array
            return array;
        }

            if ( startIndex == endIndex-1 ){
                if(array[startIndex] > array[endIndex]){
                    int temp = array[startIndex];
                    array[startIndex] = array[endIndex];
                    array[startIndex] = temp;
                }
                return array;
            }
        int middle = (startIndex+ endIndex)/2;
            int [] temp1 = mergeSort(array, startIndex, middle);
            int [] temp2 = mergeSort(array, middle+1, endIndex);

            // now merge in middle
        for( int i =startIndex, index1 = 0, index2 = 0; i <= endIndex; i++){
            if(index1 >= middle){
                array[i] = temp2[index2++];
            }
            else if (index2 >= endIndex){
                array[i] = temp1[index1++];
            }else {
                if (temp1[index1] < temp2[index2]) {
                    array[i] = temp1[index1++];
                } else {
                    array[i] = temp2[index2++];
                }
            }
        }

        return array;
    }
}
