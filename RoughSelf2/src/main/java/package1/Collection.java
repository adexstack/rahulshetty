package package1;

import java.util.*;

public class Collection {
    public static void main(String[] args) {
        String a = "Cup";
        String b = "Cup";
        String c = new String("Cup");
        System.out.println(c.equals(b));
        System.out.println(c.equals(a));
        System.out.println(c.equals(a));
        System.out.println(c==a);
        System.out.println(a.equals(b));
        System.out.println(a==b);

        StringBuilder sb = new StringBuilder("Den");
        sb.append("nis");
        System.out.println(sb.reverse());

        StringBuffer sbf = new StringBuffer("Den");
        sbf.append("nis");
        System.out.println(sbf.reverse());
        //StringBuffer is thread safe (synchronised), Stringbuilder is Not thread safe but faster

        String [] emails = {"ade.com", "fem.com", "ken.com"};
        String [] names = {"ade", "fem", "ken"};
        List<String> emailList = new ArrayList<>(Arrays.asList(emails));
        List<String> nameList = new ArrayList<>(Arrays.asList(names));

        Map<String, List<String>> details = new HashMap<>();
        details.put("emails", emailList);
        details.put("names", nameList);

        Set<String> st = details.keySet();
        for(String keys:st){
            System.out.println(details.get(keys));
        }
    }
}


