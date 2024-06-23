package manojsharmaacademy.pageObjects;

import org.openqa.selenium.WebDriver;

public class rough {
	WebDriver driver;
	
	 public rough(WebDriver driver) {
		 this.driver=driver;
	 }

	public WebDriver goToo() {
		 
		 driver.get("https://facebook.com");
		 return driver;
	 }
	 
	 
}
