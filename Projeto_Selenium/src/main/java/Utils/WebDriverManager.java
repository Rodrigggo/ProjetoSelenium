package Utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {
	
	ChromeDriver driver;
	
	@SuppressWarnings("deprecation")
	public  ChromeDriver getDriver () {		
		
		Map<String, String> prefs = new HashMap<String, String>();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/drivers/chromedriver.exe");
		prefs.put("binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		return driver;
	}

}
