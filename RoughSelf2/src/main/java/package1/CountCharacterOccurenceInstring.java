package package1;

import java.util.ArrayList;
import java.util.List;

public class CountCharacterOccurenceInstring {
    public static void main(String[] args) {
        countstringOccurence("independent", 'i');

    }
    public static void countstringOccurence(String inputString, char inputChar){
      List<String> lis = new ArrayList<>();
        int count=0;
      for(int i=0;i<inputString.length();i++){

          if(inputString.charAt(i)==inputChar){
              count++;
          }

      }
        System.out.println(inputChar +" occurs "+count+" times");

    }
}
