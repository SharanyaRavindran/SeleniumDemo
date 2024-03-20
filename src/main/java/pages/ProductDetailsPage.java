package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
	//driver
	private WebDriver driver;
	//locators
private By productName = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
private By removeButton = By.id("remove-sauce-labs-backpack");
private By cartItem = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
	//constructor
public ProductDetailsPage(WebDriver driver) {
	this.driver = driver;
}
//page actions
public String checkProductName() {
	return driver.findElement(productName).getText();
}
public void addProductToCArt() {
	driver.findElement(addToCartButton).click();
}
public boolean checkItemAdded() {
	return driver.findElement(cartItem).isDisplayed();
}
public void removeItem() {
	driver.findElement(removeButton).click();
}
	
	
}
