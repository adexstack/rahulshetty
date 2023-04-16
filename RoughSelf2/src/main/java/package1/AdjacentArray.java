package package1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentArray {
    public static void main(String[] args) {

        //Integer[] num = new Integer [] {2,5,10,8,9};
        //List <Integer> lis = Arrays.asList(num);

        int[] numbers = { 1,3,8,9,2};
        getMaxDiffInArray(numbers);

    }

    private static void getMaxDiffInArray(int[] num){
        //get a variable to hold the initial difference
        //iterate through the array and get difference
        int difference = 0;

        for(int i=0;i<num.length-1;i++){
            if (num[i+1] - num[i] > difference){
                difference = num[i+1] - num[i];
            }

        }
        System.out.println(difference);
    }

}
