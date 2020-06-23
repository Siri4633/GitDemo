package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logo03 {

	public WebDriver driver;

	By logo = By.xpath("//img[@src=\"https://goibibo.ibcdn.com/styleguide/images/goLogo.png\"]");

	public Logo03(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement companyLogo() {
		return driver.findElement(logo);
	}

}
