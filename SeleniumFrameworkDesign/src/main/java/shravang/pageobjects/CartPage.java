package shravang.pageobjects;

import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shravang.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		// Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> productTitles;

	@FindBy(css = ".totalRow button")
	WebElement checkOutEle;

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// PageFactory method. We need to initialize the Pagefactory in the constructor

	public List<WebElement> verifyCartProducts() {

		return productTitles;

	}

	public Boolean compareCartProducts(String productName) {

		Boolean match = verifyCartProducts().stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public checkOutPage goToCheckOut() {

		checkOutEle.click();
		checkOutPage checkOut = new checkOutPage(driver);
		return checkOut;
	}

}
