package greedy;

import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsack {

    int[] weight;
    int[] value;
    int weighLimit;
    int totalWeightInKnapsack = 0;
    int totalValueInKnapsack = 0;
    List<Integer> solution = new ArrayList<>();

    FractionalKnapsack(int wightLimit) {
        //initialize the problem
        weight = new int[]{5, 4, 6, 3};
        value = new int[]{10, 40, 30, 50};
        this.weighLimit = wightLimit;
    }

    public static void main(String[] args) {

        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack(7);
        fractionalKnapsack.solution(0);

    }

    public void solution(int index) {
        // I am not gonna sort then chose top n
        //instead I will start filling knap sack then removing the items
        //worst case scenario for each item we have to search for log(n) tines in knapsack so time will any way become nlog(n), same as sorting+ serching way
        //but it will save a few operations


        if (totalWeightInKnapsack < weighLimit) {

        }


    }

    int getIndexUsingBinarySearch(int value) {
        int i = 0;


        return i;
    }

}
