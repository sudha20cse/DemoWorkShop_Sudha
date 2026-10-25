package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_Page {
	public ShoppingCart_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "termsofservice")
	private WebElement termsAndConditionsCheckBox;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	@FindBy(linkText = "Orders")
	private WebElement ordersLink;

	public WebElement getOrdersLink() {
		return ordersLink;
	}

	public WebElement getTermsAndConditionsCheckBox() {
		return termsAndConditionsCheckBox;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	
	

}
