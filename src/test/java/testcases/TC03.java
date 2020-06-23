package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Logo03;
import resources.Base;

public class TC03 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 3rd TC");
	}

	@Test(priority=3)
	public void logoValidation() {

		driver.get(prop.getProperty("url"));

		Logo03 lc = new Logo03(driver);
		lc.companyLogo().click();
		System.out.println("clicked on company logo");

		String title = driver.getTitle();
		String navigate = driver.getTitle();

		if (title.equals(navigate)) {
			System.out.println("matched");
		} else {
			System.out.println(" not matched");
		}
		log.info("navigated successfully");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed fort TC03");
	}

}
