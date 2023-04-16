package package1;

public class SwapVariables {
    public static void main(String[] args) {
        int a = 5;
        int b = 4;

        int temp = a;
        a=b;
        b=temp;
        System.out.println("a :" +a +" b  :"+b);

        //swapping without using Temp variable;
        a = a+b;
        b = a - b;
        a = a - b;
    }
}
