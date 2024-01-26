package shravang.Tests;

import org.testng.annotations.Test;

//import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.Assert;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import shravang.TestComponents.BaseTest;
import shravang.pageobjects.CartPage;
import shravang.pageobjects.ProductCatalog;

public class ErrorHandlingTest extends BaseTest{
	
	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws InterruptedException, IOException {
		

		ProductCatalog prodCat = landingPage.loginApplication("shravangundu@gmail.com", "Test@123");
		System.out.println(prodCat);
		Assert.assertEquals("Incorrect email or password.", landingPage.errorMessage());
		
	}
	
	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {
		// Auto-generated method stub

		String productName = "ZARA COAT 3";

		ProductCatalog prodCat = landingPage.loginApplication("shravangundu231@gmail.com", "Test@123");

		List<WebElement> products = prodCat.getProductList();
		System.out.println(products);
		prodCat.addProductToCart(productName);
		CartPage cartPage = prodCat.clickCartButton();

		Boolean match = cartPage.compareCartProducts("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
