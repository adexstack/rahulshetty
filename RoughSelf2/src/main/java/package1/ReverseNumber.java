package package1;

public class ReverseNumber {
    public static void main(String[] args) {
        reverseNumber(5432);
    }
    public static void reverseNumber(int nums){
       int reverse = 0;
       while(nums!=0){
           int digit = nums%10;
           reverse = digit + reverse*10;
           nums=nums/10;
       }
        System.out.println(reverse);
    }
}
