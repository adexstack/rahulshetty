package package1;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class MinandMaxIn2DArray {
    public static void main(String[] args) {
        int [][] nums = {{2,4,7},{4,9,13},{6,1,3}};
        int min = nums[0][0];
        int max = nums[0][0];

        //System.out.println(nums[2][1]);
        //System.out.println(nums.length);
        for(int i=0;i<nums.length;i++){

            {
                for(int j=0;j<nums.length;j++){

                    if(nums[i][j]<min){
                        min = nums[i][j];
                    }
                    if(nums[i][j]>max){
                         max = nums[i][j];
                    }
                }
            }

        }
        System.out.println("minimum :"+min+" maximum :"+max);

    }


}
