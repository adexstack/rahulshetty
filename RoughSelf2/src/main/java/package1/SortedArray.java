package package1;

import java.util.ArrayList;
import java.util.List;

public class SortedArray {
    public static void main(String[] args) {
        int num[] = {2,6,1,4,9};
        getSortedArray(num);
    }
    public static void getSortedArray(int a[]){
        List<Integer> lis = new ArrayList<>();
        int temp;

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    // Swapping Integers
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }

            }

        }
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);}
    }
}
