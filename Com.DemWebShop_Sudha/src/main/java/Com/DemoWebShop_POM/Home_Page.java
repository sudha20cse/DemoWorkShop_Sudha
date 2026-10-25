package Com.DemoWebShop_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(partialLinkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(id = "small-searchterms")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;
	
	@FindBy(linkText = "Addresses")
	private WebElement addressLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCartLink;

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getAddressLink() {
		return addressLink;
	}
	
	

}
