package package1;

public class PrinttestPyramid {
    public static void main(String[] args) {
        testPyramid(4);
    }
    public static void testPyramid(int rowNo){
        for(int i=1;i<=rowNo;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
