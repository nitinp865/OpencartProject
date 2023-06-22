package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public Properties prop;
	public WebDriver driver;
	public void initializeDriver() throws IOException {
		//To read data
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		
		//To access data.properties file
		prop = new Properties();
		//load the read value
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			//firefox code
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//edge code
		}
		else {
			System.out.println("Please enter proper browser value");
		}
	}
	@BeforeMethod
	public void launchURL() throws IOException {
		initializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
}
