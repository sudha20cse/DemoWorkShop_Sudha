package Com.DemoWebShop_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Page {
	public CheckOut_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='Continue']")
	private List<WebElement> continueBtn ;

	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirmBtn;

	public List<WebElement> getContinueBtn() {
		return continueBtn;
	}

	public WebElement getConfirmBtn() {
		return confirmBtn;
	}
	
	
}
