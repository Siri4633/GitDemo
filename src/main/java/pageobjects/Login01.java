package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class Login01 {

	public WebDriver driver;

	By SignIn = By.id("get_sign_in");
	By frame = By.xpath("//iframe[@src=\"/accounts/login/?iframe=1&next=https%3A%2F%2Fwww.goibibo.com%2F\"]");
	By num = By.id("authMobile");
	By submit = By.id("mobileSubmitBtn");
	By popup = By.xpath("//a[@class=\"fr icon-close font12Lt popClose\"]");
	


	public Login01(WebDriver driver) {
	this.driver=driver;

	}

	public WebElement signIn() {
		return driver.findElement(SignIn);
	}

	public WebElement frame() {
		return driver.findElement(frame);
	}

	public WebElement numEntry() {
		return driver.findElement(num);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

	public WebElement popMsg() {
		return driver.findElement(popup);
	}

	
	    
}
