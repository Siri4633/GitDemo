package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products11 {

	public WebDriver driver;
	By button = By.xpath("//div[@class=\"fl width100 txtCenter padT20\"]//a[@class=\"fb button orange txtTransUpper marginB10 fltHpySrchBtn\"]");

	public Products11(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement productsButtuon() {
		return driver.findElement(button);
	}

}
