package package1;

// Note: You can also use better way;  charAt(i) hence u don't need to convert toCharArray()
public class Palindrome {
    public static void main(String[] args) {
        reverseString("madam");
    }
    public static void reverseString(String input){
       char [] newOne = input.toCharArray();
        String reversedString = "";
        for(int i = newOne.length-1; i>=0;i--){
            reversedString+=newOne[i];

        }
        if (input.equals(reversedString))
        {System.out.println("it is Palindrome");}
    }
}
