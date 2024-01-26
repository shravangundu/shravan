package shravang.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import shravang.TestComponents.BaseTest;
import shravang.pageobjects.CartPage;
import shravang.pageobjects.ConfirmationPage;
import shravang.pageobjects.LandingPage;
import shravang.pageobjects.ProductCatalog;
import shravang.pageobjects.checkOutPage;

public class StepDefinitionImpl extends BaseTest{
	
	public LandingPage landingPage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException{
		landingPage = launchApplication();
	}
	
	public ProductCatalog prodCat;
	@Given ("^Log in with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String username, String pwd) {
		
		prodCat = landingPage.loginApplication(username, pwd);
		
	}
	
	@When ("^I add product (.+) to Cart$")
	public void I_add_product_to_Cart(String productName) throws InterruptedException{
		List<WebElement> products = prodCat.getProductList();
		System.out.println(products);
		prodCat.addProductToCart(productName);
		
	}
	
	public ConfirmationPage confirmationPage;
	@When ("^Checkout (.+) and submit order$")
	public void Checkout_and_submit_order(String productName, String countryName) throws InterruptedException {
		
		CartPage cartPage = prodCat.clickCartButton();

		Boolean match = cartPage.compareCartProducts(productName);
		Assert.assertTrue(match);

		Thread.sleep(1000);
		checkOutPage checkOut = cartPage.goToCheckOut();
		confirmationPage = checkOut.checkOutPageData(countryName);
		
	}
	
	@Then ("{string} message is displayed on the confirmation page")
	public void message_is_displayed_on_the_confirmation_page(String string) {
		
		String confirmation = confirmationPage.confirmationMessageVerify();
		Assert.assertTrue(confirmation.equalsIgnoreCase(string));
		driver.close();
	}
	
	//below is the regex to catch the strArg1
	@Then("^\"([^\"]*)\" message is displayed$")
	public void  somethig_message_is_displayed(String strArg1) throws Throwable {
		Assert.assertEquals(strArg1, landingPage.errorMessage());
		driver.close();
	}
}
