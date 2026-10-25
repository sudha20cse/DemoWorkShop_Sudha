package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Com.DemoWebSHop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Books_Page;
import Com.DemoWebShop_POM.CheckOut_Page;
import Com.DemoWebShop_POM.ShoppingCart_Page;

public class TC_003_Verify_User_is_able_to_Place_Order_or_Not_Test extends BaseTest{
	
	@Test
	public void addToCart() throws IOException, InterruptedException {
		
		homePage.getSearchTextField().sendKeys(fileUtility.readDataFromPropertyFile("productName") + Keys.ENTER);
		
		Books_Page booksPage=new Books_Page(driver);
//		booksPage.getAddToCartBtn().click();
		webdriverUtility.javaScriptClick(driver, booksPage.getAddToCartBtn());
		
		Thread.sleep(2000);
		homePage.getShoppingCartLink().click();
		
		ShoppingCart_Page shoppingCartPage=new ShoppingCart_Page(driver);
		shoppingCartPage.getTermsAndConditionsCheckBox().click();
		shoppingCartPage.getCheckoutBtn().click();
		
		CheckOut_Page checkOutPage=new CheckOut_Page(driver);
		checkOutPage.getContinueBtn().get(0).click();
		checkOutPage.getContinueBtn().get(1).click();
		checkOutPage.getContinueBtn().get(2).click();
		checkOutPage.getContinueBtn().get(3).click();
		checkOutPage.getContinueBtn().get(4).click();
		checkOutPage.getConfirmBtn().click();
		
		Thread.sleep(2000);
		webdriverUtility.javaScriptClick(driver, shoppingCartPage.getOrdersLink());
		
		Thread.sleep(2000);
		webdriverUtility.webpageScreenshot(driver);
		
	}

}
