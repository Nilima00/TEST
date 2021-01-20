package firstTestNg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Try {

	WebDriver driver;
	String browser = null;

	@BeforeClass
	public void filereader1() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void init() throws InterruptedException {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.get("https://techfios.com/billing/?ng=admin/");
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);

		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("demo@techfios.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abc123");
		WebElement button = driver.findElement(By.name("login"));
		button.click();
	//	Assert.assertEquals("Login - iBilling", driver.getTitle());
		Thread.sleep(2000);
		WebElement customerLink = driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
		customerLink.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]")).click();
		
		String fullname = "XYZ";

		Thread.sleep(2000);
		Random rdn = new Random();
		int x = rdn.nextInt(999);
		By name = By.id("account");
		driver.findElement(name).sendKeys(fullname + x);
		

	}

}
