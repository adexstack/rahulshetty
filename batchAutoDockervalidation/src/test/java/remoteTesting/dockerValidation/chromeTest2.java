package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class chromeTest2 {

@Test
public void test2() throws MalformedURLException
{
		// TODO Auto-generated method stub
		ChromeOptions cap=new ChromeOptions();
		URL u=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(u,cap);
		driver.get("http://gmail.com");
		System.out.println(driver.getTitle());
		
	}

}
