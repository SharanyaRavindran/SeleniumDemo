package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	private WebDriver driver;
	// private By locators
	private By backPackLink = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
	private By sortSlect = By.xpath("//select[@class='product_sort_container']");

	// public constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// public page actions
	public ProductDetailsPage clickBackpack() {
		driver.findElement(backPackLink).click();
		return new ProductDetailsPage(driver);
	}

	public void selectSort(String sortValue) {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
		WebElement sort = driver.findElement(sortSlect);
		Select select = new Select(sort);
		select.selectByVisibleText(sortValue);
	}

	public boolean checkIfSortedByPriceLowToHigh() {
		List<WebElement> priceSortedElements = driver.findElements(
				By.xpath("//div[@class='inventory_item_name ']/parent::a/parent::div/following-sibling::div/div"));
		List<Float> prices = new ArrayList<>();
		for (int i = 0; i < priceSortedElements.size(); i++) {
			WebElement product = priceSortedElements.get(i);
			System.out.println(product.getText().substring(1));
			Float price = Float.valueOf(product.getText().substring(1));
			prices.add(price);
		}
		System.out.println(prices);
		for (int i = 0; i < prices.size() - 1; i++) {
			if (prices.get(i) > prices.get(i + 1)) {
				return false;
			}
		}
		return true;
	}
	

}
