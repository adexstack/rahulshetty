import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamstest2 {

	//COunt the number of names starting with alphabet A in list
	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("abhijeet");
		names.add("don");
		names.add("alekhya");
		names.add("adam");
		names.add("ram");

		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Fshijeet");
		names1.add("dod");
		names1.add("rlekhyt");
		names1.add("adam");
		names1.add("rak");

		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(System.out::println);
		//newStream.sorted().distinct().forEach(System.out::println);
		assert newStream.anyMatch(s -> s.equalsIgnoreCase("Adam")); //anymatch returns boolean

	}
	@Test
	void uniqueSort(){
		List<Integer> ls = Arrays.asList(3,2,2,7,5,1,9,7);
		List<Integer> bs = Arrays.asList(3,2,2,7,5,1,9,7);
		ls.stream().distinct().sorted().forEach(System.out::println);
		System.out.println("--------------------------");
		List<Integer> bs1 = bs.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(bs1.get(2));
	}
}

