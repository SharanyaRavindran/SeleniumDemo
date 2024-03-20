package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;
import pages.ProductPage;

public class ProductDetailsSteps {
	private WebDriver driver= DriverFactory.getDriver();
	private ProductPage productPage = new ProductPage(driver);
	private ProductDetailsPage detailsStpes;
	
	@Given("User clicks on the first product")
	public void user_clicks_on_the_first_product() {
		detailsStpes=productPage.clickBackpack();
	}

	@Given("User is on the product details page")
	public void user_is_on_the_product_details_page() {
		System.out.println("User is no the product details page");
	}

	@When("User clicks Add to Cart button")
	public void user_clicks_add_to_cart_button() {
		detailsStpes.addProductToCArt();
	}

	@Then("Product is added to cart")
	public void product_is_added_to_cart() {
		Assert.assertTrue(detailsStpes.checkItemAdded());
	}

	@Given("User added to product to cart")
	public void user_added_to_product_to_cart() {
		detailsStpes.addProductToCArt();
	}

	@When("User clicks Remove button")
	public void user_clicks_remove_button() {
		detailsStpes.removeItem();
	}

	@Then("Product is removed from cart")
	public void product_is_removed_from_cart() {
		try {
		detailsStpes.checkItemAdded();
		}catch(NoSuchElementException e) {
			Assert.assertTrue(true);
		}
	}


}
