package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjectModel.HomePageObjects;
import Resources.baseClass;
import Resources.commonUtilities;
import Resources.constant;

public class addToCartAndVerify extends baseClass{
	@Test
	public void addToCart() throws IOException {
		driver.manage().window().maximize();
		WebDriverWait wb=new WebDriverWait(driver, Duration.ofSeconds(10));
		//Iphone code
		HomePageObjects HPO = new HomePageObjects(driver);
		HPO.enterAtSearchBar().sendKeys(constant.iphoneName);
		HPO.clickOnSearch().click();
		HPO.clickOnAddCartIphone().click();
		String priceTextIphone = HPO.getIphonePriceText().getText();
		String splitIphoneText[] = priceTextIphone.split("\\s+");
		String iphonePrice = splitIphoneText[0];
		String removingDollarIphone = iphonePrice.replace("$", "");
		//To convert string to double
		double d1 = Double.parseDouble(removingDollarIphone);
		System.out.println(d1);
		 
		//Samsung code
		wb.until(ExpectedConditions.visibilityOf(HPO.enterAtSearchBar()));
		HPO.enterAtSearchBar().clear();
		HPO.enterAtSearchBar().sendKeys(constant.samsungName);
		HPO.clickOnSearch().click();
		HPO.clickOnAddCartSamsung().click(); 
		String priceTextSamsung = HPO.getSamsungPriceText().getText();
		String splitSamsungText[] = priceTextSamsung.split("\\s+");
		String samsungPrice = splitSamsungText[0];
		String removingDollarSamsung = samsungPrice.replace("$", "");
		//to convert string to double
		double d2 = Double.parseDouble(removingDollarSamsung);
		System.out.println(d2);
		
		//sum of both product
		double d = d1 + d2;
		String sumOfProduct = "$"+d;
		
		//to get cart value
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		HPO.clickOnCart().click();
		//wb.until(ExpectedConditions.visibilityOf(HPO.getCartValue()));
		String cartValue = HPO.getCartValue().getText();
		
		commonUtilities.handleAssertions(sumOfProduct, cartValue);
	}
}
