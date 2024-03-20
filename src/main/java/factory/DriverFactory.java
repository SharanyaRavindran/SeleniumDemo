package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
		public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
		public WebDriver initializeDriver(String browser) {
			System.out.println(browser);
			switch(browser) {
			case "chrome":{
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
				break;
			}
			case "edge":{
				WebDriverManager.edgedriver().setup();
				tlDriver.set(new EdgeDriver());
				break;
			}
			case "firefox":{
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
				break;
			}
			default:
				System.out.println("Enter valid browser");
			}
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			return getDriver();
			}
		
		public static synchronized WebDriver getDriver() {
			return tlDriver.get();
		}

}
