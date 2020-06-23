package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.EarnCredits06;
import resources.Base;

public class TC06 extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 6th TC");
	}

	@Test(priority=5)
	public void earnCreditNavigation() {
		driver.get(prop.getProperty("url"));

		EarnCredits06 tc06 = new EarnCredits06(driver);
		tc06.goCashTitle().click();

		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		System.out.println(title + " " + url);

		boolean value = driver.getCurrentUrl().contains("gocash-benefits");
		Assert.assertTrue(value, "correctly navigated");
		log.info("Succesfully validated the text message");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed for TC06");
	}

}
