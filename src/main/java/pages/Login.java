package pages;

//import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	private WebDriver driver;
//private By locators
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.xpath("//h3");
	//public constructor
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	//public page actions
	public String getPageTitle() {
		return driver.getTitle();
	}
	public boolean checkError() {
		try {
		return driver.findElement(errorMessage).isDisplayed();
		}catch(Exception e) {
			System.out.println("no error");
			return false;
		}
	}
	public void enterUserName(String user_name) {
		driver.findElement(userName).sendKeys(user_name);
	}
	public void enterPasswrod(String string) {
		driver.findElement(password).sendKeys(string);
	}
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	public ProductPage doLogin(String un,String pw) {
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		driver.findElement(loginButton).click();
		return new ProductPage(driver);
	}
}
