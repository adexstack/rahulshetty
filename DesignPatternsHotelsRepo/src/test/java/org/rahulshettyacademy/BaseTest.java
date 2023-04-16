package org.rahulshettyacademy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

    public WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8); // From Apache common to convert file to string; adding UTF_8 to avoid encoding issue
        ObjectMapper mapper = new ObjectMapper();  // Convert json string to java objects using jackson core, databind
        // Unmashalling jsonContent to list of hashmaps using TypeReference
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});
    }
}
