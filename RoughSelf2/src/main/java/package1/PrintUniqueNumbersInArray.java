package package1;

import java.util.*;

public class PrintUniqueNumbersInArray {
    public static void main(String[] args) {


        int a[] = {4, 5, 5, 5, 4, 6, 6, 9, 4};
        List<Integer> lis = new ArrayList<>();
        for(int i=0;i<a.length;i++){
          int k = 0;
            if(!lis.contains(a[i])){
                lis.add(a[i]);
                k++;

                for(int j=i+1;j<a.length;j++){
                    if(a[j]==a[i]){
                        k++;
                    }

                }
                System.out.println(a[i]+" occurs :"+k+" times");
                if(k==1)
                    System.out.println(a[i]+" is unique");


            }

        }
    }}