package package1;

public class PrintMultiplicationTable {
    public static int printMultiplicationTable(int num, int numTimes){
        int k = 1;
        int sum = 0;
        while(k<=numTimes){
            sum+=num;
            k++;

        }
        return sum;
    }
    public static void main(String[] args) {
        int m = printMultiplicationTable(5,20);
        System.out.println(m);
    }
}
