package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserPhoto04 {

	public WebDriver driver;

	By icon = By.xpath("//div[@class='userPhoto']");
	By sublinks = By.xpath("//div[@class='tip tip_top right white moreSubLinks']/ul");
	By subheader = By.tagName("a");

	public UserPhoto04(WebDriver driver) {
		this.driver = driver;
	}

	
	
	

	public WebElement iconValidation() {
		return driver.findElement(icon);
	}
	public void actionsTab() {
		Actions action = new Actions(driver);
		action.moveToElement(iconValidation()).build().perform();
	}

	public WebElement subLinks() {
		return driver.findElement(sublinks);
	}

	public List<WebElement> subHeader() {
		return driver.findElements(subheader);
	}
}

