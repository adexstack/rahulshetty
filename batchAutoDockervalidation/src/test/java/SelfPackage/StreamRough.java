package SelfPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamRough {
    public static void main(String[] args) {
        List<String> lis1 = new ArrayList<>();
        lis1.add("Ade");
        lis1.add("Femi");
        lis1.add("Quebec");
        lis1.add("Acxi");
        int count = 0;
        for (String k:lis1
             ) {
            //System.out.println(k);
            if(k.startsWith("A")){
                count++;
            }

        }
        //System.out.println(count);
        //System.out.println(lis1.stream().allMatch(s->s.);
    }
}
