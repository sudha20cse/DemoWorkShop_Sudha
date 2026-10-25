package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Books_Page {
	public Books_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCartBtn;

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	
}
