package manojsharmaacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojsharmaacademy.AbstractComponents.AbstractComponents;

public class PaymentWindow extends AbstractComponents{

	WebDriver driver;
	public PaymentWindow(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "[placeholder='Select Country']")
	WebElement countryBox;
	
//	@FindBy (css="ta-results ")
//	WebElement allCountryWindow;
	
	@FindBy (xpath="(//* [contains(text(),'India')])[2]")
	WebElement SelectedCountry;
	
	@FindBy (css=".action__submit")
	WebElement placeOrderButton;
	
	public void selectCountryBox(String country) {
		
	countryBox.sendKeys(country);
	//WaitTillVisibilityOfElement(allCountryWindow);
	SelectedCountry.click();
			
	}

	public OrderConfirmation placeOrder() {
		placeOrderButton.click();		
		OrderConfirmation orderConfirmation=new OrderConfirmation(driver);
		return orderConfirmation;
	}
}
