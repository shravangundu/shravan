package shravang.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import shravang.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> orderList;

	// PageFactory method. We need to initialize the Pagefactory in the constructor

	public Boolean verifyOrderDisplay(String productName) {

		Boolean match = orderList.stream().anyMatch(orderName -> orderName.getText().equalsIgnoreCase(productName));
		return match;
	}

}
