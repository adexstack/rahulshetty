package files;

public class payload2 {

	public static String addBook(String isbn, String aisle){
		String addbook = "{\n" +
				"\"name\":\"Learn Appium Automation with Java\",\n" +
				"\"isbn\":\""+isbn+"\",\n" +
				"\"aisle\":\""+aisle+"\",\n" +
				"\"author\":\"John foe\"\n" +
				"}\n";
		return addbook;
	}
	

	
	
}
