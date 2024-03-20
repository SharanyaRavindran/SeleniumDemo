package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginPageSteps {
	private WebDriver driver= DriverFactory.getDriver();
	private Login login=new Login(driver);
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		driver.get("https://www.saucedemo.com/");
	}
	@When("User enters user name {string}")
	public void user_enters_user_name(String user_name) {
		login.enterUserName(user_name);
	}

	@And("User enters  password {string}")
	public void user_enters_password(String password) {
		login.enterPasswrod(password);
	}

	@And("User clicks Login Button")
	public void user_clicks_login_button() {
		login.clickLoginButton();
	}
	@Then("User should be logged in")
	public void user_should_be_loggerin() {
		Assert.assertFalse(login.checkError());
	}
}
