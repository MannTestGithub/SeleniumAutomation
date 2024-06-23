package manojsharmaacademy.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import manojsharmaacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="userEmail")
	WebElement loginEmail;
	
	@FindBy (id="userPassword")
	WebElement loginPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	public productCatelogue loginInitialization(String email, String password) {
				
		loginEmail.sendKeys(email);
		loginPassword.sendKeys(password);
		loginButton.click();
		productCatelogue productcatelogue=new productCatelogue(driver);
		return productcatelogue;
	}
	
	
	
}
