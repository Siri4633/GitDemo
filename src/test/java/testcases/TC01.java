package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Login01;
import resources.Base;

public class TC01 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();

		log.info("Driver is initialized for 1ST TC");
	}

	@Test(priority=1)
	public void loginValidation() {
		driver.get(prop.getProperty("url"));

		Login01 l = new Login01(driver);
		l.signIn().click();

		driver.switchTo().frame(l.frame());
		l.numEntry().sendKeys("7895642356");
		l.submit().click();

		driver.switchTo().defaultContent();
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		l.popMsg().click();
		log.info("logged In");

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed for TC01");
	}
}
