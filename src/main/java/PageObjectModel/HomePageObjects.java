package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	WebDriver driver;
	private By searchBar = By.xpath("//input[@type='text']");
	private By search = By.xpath("//button[@class='btn btn-default btn-lg']");
	private By addCartIphone = By.xpath("(//i[@class='fa fa-shopping-cart'])[3]");
	private By priceTextIphone = By.xpath("//p[@class='price']");
	private By addCartSamsung = By.xpath("(//i[@class='fa fa-shopping-cart'])[5]");
	private By priceTextSamsung = By.xpath("(//p[@class='price'])[2]");
	private By cart = By.xpath("(//button[@type='button'])[5]");
	private By cartValue = By.xpath("(//td[@class='text-right'])[12]");
	
	public HomePageObjects(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}
	public WebElement enterAtSearchBar() {
		return driver.findElement(searchBar);
	}
	public WebElement clickOnSearch() {
		return driver.findElement(search);
	}
	public WebElement clickOnAddCartIphone() {
		return driver.findElement(addCartIphone);
	}
	public WebElement getIphonePriceText() {
		return driver.findElement(priceTextIphone);
	}
	public WebElement clickOnAddCartSamsung() {
		return driver.findElement(addCartSamsung);
	}
	public WebElement getSamsungPriceText() {
		return driver.findElement(priceTextSamsung);
	}
	public WebElement clickOnCart() {
		return driver.findElement(cart);
	}
	public WebElement getCartValue() {
		return driver.findElement(cartValue);
	}
}
