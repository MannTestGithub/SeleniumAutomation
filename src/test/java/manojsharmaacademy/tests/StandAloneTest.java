package manojsharmaacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import manojsharmaacademy.TestComponents.BaseTest;
import manojsharmaacademy.pageObjects.CartItemsCheckout;
import manojsharmaacademy.pageObjects.OrderConfirmation;
import manojsharmaacademy.pageObjects.PaymentWindow;
import manojsharmaacademy.pageObjects.productCatelogue;

public class StandAloneTest extends BaseTest {

	@Test
	public void submitOrder() {

		String productName = "ZARA COAT 3";

		productCatelogue productcatelogue = landingPage.loginInitialization("useless.id2023@gmail.com", "Mann@1510");

		productcatelogue.getProductList();
		productcatelogue.getProductName(productName);
		productcatelogue.addItemToCart(productName);
		CartItemsCheckout cartItemsCheckout = productcatelogue.goToCart();
		boolean match = cartItemsCheckout.itemsInCart(productName);
		Assert.assertTrue(match, productName);
		PaymentWindow paymentWindow = cartItemsCheckout.checkout();
		paymentWindow.selectCountryBox("India");
		OrderConfirmation orderConfirmation = paymentWindow.placeOrder();
		boolean match1 = orderConfirmation.conFirmOrder("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(match1);

	}

	@Test
	public void dummyTest() {

		String email="useless.id2023@gmail.com";
		String Password="Mann@151";
	
		landingPage.loginInitialization(email, Password);
		
		Assert.assertEquals("Incorrect email  password.", landingPage.loginError());
		
	}
}
