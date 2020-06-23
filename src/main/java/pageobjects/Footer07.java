package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Footer07 {

	public WebDriver driver;

	By footer = By.xpath("//div[@class=\"col-md-10 col-sm-12 padB20\"]");
	By subfooter = By.xpath("//ul[@class=\"col-md-3 col-sm-3 footerLinks\"]//a");

	public Footer07(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement footerValidation() {
		return driver.findElement(footer);
	}

	public List<WebElement> subfooterValidation() {
		return driver.findElements(subfooter);
	}

}
