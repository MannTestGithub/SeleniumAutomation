package manojsharmaacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojsharmaacademy.AbstractComponents.AbstractComponents;

public class CartItemsCheckout extends AbstractComponents{

	WebDriver driver;
	public CartItemsCheckout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (css= ".cartSection h3")
	List<WebElement> ListOfitemsInCart;
	
	@FindBy (xpath="//button[text()='Checkout']")
	WebElement checkOutButton;
	
	
	
	
	public boolean itemsInCart(String productName) {
		boolean match=ListOfitemsInCart.stream().anyMatch(product->product.getText().equals(productName));
		return match;
		
	}
	
	public PaymentWindow checkout() {
		checkOutButton.click();	
		PaymentWindow paymentWindow= new PaymentWindow(driver);
		return paymentWindow;
	}
	
	
	
}
