package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Offers09 {

	public WebDriver driver;
	By button = By.xpath("//a[@href=\"https://www.goibibo.com/offers/flight-offers/\"]");

	public Offers09(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement offersButtuon() {
		return driver.findElement(button);
	}
}
