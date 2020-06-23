package testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Products11;
import resources.Base;

public class TC11 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 11th TC");
	}

	@Test(priority=8)
	public void productWindows() {

		driver.get(prop.getProperty("url"));

		Products11 tc11 = new Products11(driver);
		tc11.productsButtuon().click();
		System.out.println("navigated to products");

		String first = driver.getWindowHandle();
		System.out.println(first);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();

		while (itr.hasNext()) {
			String child = itr.next();
			if (!(child.contains(first))) {
				driver.switchTo().window(child);
				String title = driver.getTitle();
				System.out.println(title + "  " + child);
				driver.close();
				log.info(title + "  " + child);
			}
		}

		driver.switchTo().window(first);
		System.out.println(driver.getTitle());

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed for TC11");
	}
}
