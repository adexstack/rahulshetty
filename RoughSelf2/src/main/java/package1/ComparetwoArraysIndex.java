package package1;

import java.util.ArrayList;
import java.util.List;

public class ComparetwoArraysIndex {
    public static void main(String[] args) {
        int a[] = {1,4,5,7};
        int b[] = {6,4,3,7};
        System.out.println(getMatchingArrayIndex(a,b));


    }
    public static List<Integer> getMatchingArrayIndex(int a[], int b[]){

        List<Integer> lis = new ArrayList<>();

        for(int i=0;i<a.length;i++){
            if(a[i]==b[i]){
                lis.add(a[i]);
            }
        }
        return lis;
    }

}
