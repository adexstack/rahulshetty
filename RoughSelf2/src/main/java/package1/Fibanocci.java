package package1;

public class Fibanocci {
    public static void main(String[] args) {
        printFibonacci(5);
    }
    public static void printFibonacci(int fibNum){
        int a = 0;
        int b = 1;
        int sum = 0;
        int i = 1;
        while(i<=fibNum){
            sum = a+b;
            System.out.println(sum);
            a=b;
            b=sum;
            i++;
        }
    }
}
