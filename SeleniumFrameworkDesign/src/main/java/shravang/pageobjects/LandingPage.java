package shravang.pageobjects;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shravang.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));
	// PageFactory method. We need to initialize the Pagefactory in the constructor

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passKey;

	@FindBy(css = ".btn.btn-block.login-btn")
	WebElement submit;
	
	@FindBy(css = "[class*=flyInOut]")
	WebElement errorMessage;
	

	public ProductCatalog loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		passKey.sendKeys(password);
		submit.click();
		ProductCatalog prodCat = new ProductCatalog(driver);
		return prodCat;
	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String errorMessage() {
		waitExplicitlyforWebElement(errorMessage);
		return errorMessage.getText();
		
	}
}
