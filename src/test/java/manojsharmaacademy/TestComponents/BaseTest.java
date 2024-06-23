package manojsharmaacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import manojsharmaacademy.pageObjects.LandingPage;
import manojsharmaacademy.pageObjects.rough;

public class BaseTest {

	
	 public WebDriver driver;
	 public LandingPage landingPage;
	
	
	public WebDriver invokeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\91935\\eclipse-workspace\\SeleniumFrameworkRevision\\src\\main\\java\\manojsharmaacademy\\Resources\\GlobalComponents.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("fireFox")) {

			driver = new FirefoxDriver();
			
			
		} else if (browser.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
	}
	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver=invokeDriver();
		landingPage=new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
