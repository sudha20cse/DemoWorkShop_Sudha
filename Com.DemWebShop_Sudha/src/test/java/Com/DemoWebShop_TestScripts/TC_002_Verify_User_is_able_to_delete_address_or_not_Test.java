package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.DemoWebSHop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Address_Page;

public class TC_002_Verify_User_is_able_to_delete_address_or_not_Test extends BaseTest{
	
	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		
		webdriverUtility.javaScriptScrollTillElement(driver, homePage.getAddressLink());
		homePage.getAddressLink().click();
		
		Address_Page addressPage=new Address_Page(driver);
		addressPage.getDeleteAddressBtn().get(1).click();
		
		webdriverUtility.javaScriptPopupAccept(driver);
				
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		Thread.sleep(2000);
		webdriverUtility.webpageScreenshot(driver);
		
	}

}
