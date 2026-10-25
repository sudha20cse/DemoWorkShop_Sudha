package Com.DemoWebShop_TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebSHop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.AddNewAddress_Page;
import Com.DemoWebShop_POM.Address_Page;

public class TC_001_Verify_User_is_able_to_add_Address_or_not_Test extends BaseTest{
	
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("Add Address Test Script");
		
		webdriverUtility.javaScriptScrollTillElement(driver, homePage.getAddressLink());
		homePage.getAddressLink().click();
		
		Address_Page AddressPage=new Address_Page(driver);
		AddressPage.getAddNewAddressBtn().click();
		
		AddNewAddress_Page addNewAddressPage=new AddNewAddress_Page(driver);
		addNewAddressPage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 0));
		addNewAddressPage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 1));
		addNewAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 2));
		
		webdriverUtility.selectByVisibleText(addNewAddressPage.getCountryDropDown(), fileUtility.readDataFromExcelFile("Sheet1", 2, 3));
		
		addNewAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 4));
		addNewAddressPage.getAddress1TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 5));
		addNewAddressPage.getZipCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 6));
		addNewAddressPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 2, 7));
		addNewAddressPage.getAddressSaveBtn().click();
		
		Thread.sleep(2000);
		
		webdriverUtility.webpageScreenshot(driver);
		
	}

}
