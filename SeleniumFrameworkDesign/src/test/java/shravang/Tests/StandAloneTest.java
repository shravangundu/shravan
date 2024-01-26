package shravang.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;
import java.util.HashMap;
//import java.time.Duration;
import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import shravang.TestComponents.BaseTest;
import shravang.pageobjects.CartPage;
import shravang.pageobjects.ConfirmationPage;
import shravang.pageobjects.OrderPage;
import shravang.pageobjects.ProductCatalog;
import shravang.pageobjects.checkOutPage;

public class StandAloneTest extends BaseTest {

	// Select an order and Submit

	String productName = "ZARA COAT 3";
	String countryName = "India";

	@Test(groups = {"Purchase"}, dataProvider = "getData")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		// Auto-generated method stub

		ProductCatalog prodCat = landingPage.loginApplication(input.get("emailID"), input.get("pwd"));

		List<WebElement> products = prodCat.getProductList();
		System.out.println(products);
		prodCat.addProductToCart(input.get("product"));
		CartPage cartPage = prodCat.clickCartButton();

		Boolean match = cartPage.compareCartProducts(input.get("product"));
		Assert.assertTrue(match);

		Thread.sleep(1000);
		checkOutPage checkOut = cartPage.goToCheckOut();
		ConfirmationPage confirmationPage = checkOut.checkOutPageData(countryName);

		String confirmation = confirmationPage.confirmationMessageVerify();
		Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	// Validation of Order History
	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {

		ProductCatalog prodCat = landingPage.loginApplication("shravangundu231@gmail.com", "Test@123");
		OrderPage orderPage = prodCat.goToOrdersPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay(productName));

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		//Parameterization using HashMaps
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/shravang/Data/PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
		
	}
		
		//Hardcoding using the HashMaps
		
		//		HashMap<String, String> map = new HashMap<String String>();
		//		map.put(“emailID”, “shravan@gmail.com”);
		//		map.put(”pwd”, “Test@123”);
		//		map.put(“productName”, “Zara Coat 3”);
		//
		//		HashMap<String, String> map1 = new HashMap<String String>();
		//		map.put(“emailID”, “shravan2@gmail.com”);
		//		map.put(”pwd”, “Test@123”);
		//		map.put(“productName”, “ADIDAS SHOE”);
		//		return new Object [][] {{map},{map1}};
		
		//Hard coding using the arrays
		
		//		return new Object[][] { { "shravangundu231@gmail.com", "Test@123", "ZARA COAT 3" },
		//				{ "shravangundu231@gmail.com", "Test@123", "ADIDAS ORIGINAL" } };

}
