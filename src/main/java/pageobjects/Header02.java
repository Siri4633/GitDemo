package pageobjects;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Header02 {

	public WebDriver driver;

	By header = By.xpath("//div[@class=\"col-md-8 col-sm-8 col-xs-6 pad0 marginT5\"]/ul");
	By subheader = By.tagName("a");

	public Header02(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement headerValidation() {
		return driver.findElement(header);
	}
	public List<WebElement> subheaderValidation() {
		return headerValidation().findElements(subheader);
	}
}


















/*
 * public List<WebElement> subheaderValidation() { return
 * driver.findElements(subheader); }
 * 
 * //@FindBy(xpath="a")
 * 
 * @FindBys(value=@FindBy(xpath="a"))
 */
