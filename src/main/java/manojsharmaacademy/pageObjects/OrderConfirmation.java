package manojsharmaacademy.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojsharmaacademy.AbstractComponents.AbstractComponents;

public class OrderConfirmation extends AbstractComponents{
	WebDriver driver;
	public OrderConfirmation(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="td h1")
	WebElement orderConfirmation;
	
	public boolean conFirmOrder(String ConfirmMessage) {
		WaitTillVisibilityOfElement(orderConfirmation);
		boolean match=orderConfirmation.getText().equals(ConfirmMessage);
		return match;
	}
}
