package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoCareSupport05 {

	public WebDriver driver;

	By link = By.xpath("//span[text()=' 24x7 goCare Support']");

	public GoCareSupport05(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement goCareSupport() {
		return driver.findElement(link);
	}
}
