package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class AppHooks {
	
	private DriverFactory driverFactory; 
	private WebDriver driver;
	private ConfigReader configreader;
	String browserName;
	Properties prop; 
	@Before(order = 0)
	public void readPropery() {
		configreader = new ConfigReader();
		prop = configreader.readProperty();
		browserName= prop.getProperty("browser");
		}
	@Before(order = 1)
	public void openBrowser() {
		driverFactory = new DriverFactory();
		driver = driverFactory.initializeDriver(browserName);
	}
	@After(order = 1)
	public void takeScreenshotOnFail(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	@After(order = 0)
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}
