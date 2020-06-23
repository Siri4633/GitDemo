package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.GoCareSupport05;

import resources.Base;

public class TC05 extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Driver is initialized for 5th TC");
	}

	@Test(priority=4)
	public void supportValidation() {
		driver.get(prop.getProperty("url"));

		GoCareSupport05 s05 = new GoCareSupport05(driver);

		s05.goCareSupport().click();
		System.out.println("clicked on link");

		System.out.println(driver.getCurrentUrl());

		String text = driver.findElement(By.xpath("//span[@class=\"subHead\"]")).getText();
		Assert.assertEquals(text, "We are here to help, Manage your booking or raise concern against your booking");
		log.info("Succesfully validated the text message");

		log.info(text);

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		log.info("Driver is closed for TC05");
	}
}
