package shravang.pageobjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shravang.AbstractComponents.AbstractComponents;

public class checkOutPage extends AbstractComponents {

	WebDriver driver;

	public checkOutPage(WebDriver driver) {
		// Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".form-group input")
	private WebElement country;

	@FindBy(css = ".ta-item span")
	private WebElement clickCountry;

	@FindBy(css = ".actions a")
	private WebElement placeOrder;

	public ConfirmationPage checkOutPageData(String countryName) {
		country.sendKeys(countryName);
		clickCountry.click();
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}

}
