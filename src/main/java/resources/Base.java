package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeBrowser() throws IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Shirisha Workspace\\New Space\\GoibiboFramework\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", "D:\\Shirisha Workspace\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenshotPath(String result, WebDriver driver) throws IOException {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + result + ".png";
		FileUtils.copyFile(src, new File(destinationFile));
return destinationFile;
	}

}
