import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamstest1 {

	//COunt the number of names starting with alphabet A in list
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("abhijeet");
		names.add("don");
		names.add("alekhya");
		names.add("adam");
		names.add("ram");
		int count = 0;

		long d = names.stream().filter(s -> s.startsWith("A")).count();
		//System.out.println(d);

		//names.stream().filter(s->s.length()>4).limit(1).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//List<String> k = names.stream().filter(s->s.length()>4).limit(1).map(s->s.toUpperCase()).collect(Collectors.toList());
		names.stream().filter(s->s.startsWith("a")).sorted().forEach(System.out::println);
		//abhijeet adam alekhya

	}
}

