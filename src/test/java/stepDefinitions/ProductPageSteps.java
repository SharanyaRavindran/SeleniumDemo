package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;
import pages.ProductPage;
public class ProductPageSteps {
 
	private WebDriver driver= DriverFactory.getDriver();
	private Login login=new Login(driver);
	private ProductPage productPage;
	String title;
	@Given("User is logged in with correct user name and passowrd")
	public void user_is_logged_in_with_correct_user_name_and_passowrd(DataTable dataTable) {
     List<Map<String,String>> cred =dataTable.asMaps();
     String username=cred.get(0).get("username");
     System.out.println(username);
     String password=cred.get(0).get("password");
     System.out.println(password);
     driver.get("https://www.saucedemo.com/");
     productPage=login.doLogin(username, password);
	}

	@Given("User is on the Product page")
	public void user_is_on_the_product_page() {
		System.out.println("User is on the products page");
	}

	@When("User sorts by {string}")
	public void user_sorts_by_price_low_to_high(String sortValue) {
		productPage.selectSort(sortValue);
	}

	@Then("The products should be sorted by price\\(low to high)")
	public void the_products_should_be_sorted_by_price_low_to_high() {
		Assert.assertTrue(productPage.checkIfSortedByPriceLowToHigh());
	}
}
