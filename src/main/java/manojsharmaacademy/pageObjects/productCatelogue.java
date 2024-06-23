package manojsharmaacademy.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manojsharmaacademy.AbstractComponents.AbstractComponents;

public class productCatelogue extends AbstractComponents {

	WebDriver driver;

	public productCatelogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By products = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By ToastMessaget = By.cssSelector("div[aria-label='Product Added To Cart']");

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(css = ".mb-3")
	List<WebElement> ListOfProducts;

	@FindBy(css = "div[aria-label='Product Added To Cart']")
	WebElement getTextAddedToCart;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButton;
	public List<WebElement> getProductList() {

		WaitTillVisibilityOfLocator(products);
		return ListOfProducts;
	}

	public WebElement getProductName(String productName) {

		WebElement prod = ListOfProducts.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;
	}

	public void addItemToCart(String productName) {
		WebElement prod = getProductName(productName);

		prod.findElement(addToCart).click();
		WaitTillVisibilityOfLocator(ToastMessaget);
		WaitTillInvisibilityOfElement(spinner);
		// System.out.println(getTextAddedToCart.getText());
	}
	
	public CartItemsCheckout goToCart() {
		cartButton.click();
		CartItemsCheckout cartItemsCheckout =new CartItemsCheckout(driver);
		return cartItemsCheckout;
	}
	
	

}
