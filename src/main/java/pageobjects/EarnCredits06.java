package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EarnCredits06 {
	public WebDriver driver;

	By goCash = By.xpath("//span[text()='Earn credits']");

	public EarnCredits06(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement goCashTitle() {
		return driver.findElement(goCash);
	}
}
