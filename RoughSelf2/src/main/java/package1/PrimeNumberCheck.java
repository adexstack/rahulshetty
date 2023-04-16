package package1;

// Prime number is a number that has only 2 factors (1 and itself). It would have remainder if divided by any other number
public class PrimeNumberCheck {
    public static void main(String[] args) {
        isPrime(11);
    }
    public static void isPrime(int num){
        boolean flag = false;
        for( int i=2;i<(num/2);i++){
            if(num%i==0){
                flag=true;
                break;
            }

        }
        if(flag){
            System.out.println("It is not a prime number");
        } else {
            System.out.println("It is a prime number");
        }
    }
}
