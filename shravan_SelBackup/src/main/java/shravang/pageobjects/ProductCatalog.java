package shravang.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shravang.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		// Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// PageFactory method. We need to initialize the Pagefactory in the constructor
	// List<WebElement> products = driver.findElements(By.cssSelector("div[class =
	// 'card-body']"));

	@FindBy(css = "div[class = 'card-body']")
	List<WebElement> products;

	By productsBy = By.cssSelector("div[class = 'card-body']");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	@FindBy(css = ".ng-animating")
	WebElement spinner; 
	

	public List<WebElement> getProductList() {

		waitExplicitlyforElement(productsBy);
		return products;

	}

	public WebElement getProductByName(String ProductName) {

		WebElement product = getProductList().stream()
				.filter(name -> name.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst()
				.orElse(null);
		return product;
	}

	public void addProductToCart(String ProductName) {
		
		WebElement product = getProductByName(ProductName);
		product.findElement(addToCart).click();
		waitExplicitlyforElement(toastMessage);
		waitForElementToDisappear(spinner);
		
	}
}
