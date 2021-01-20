package firstTestNg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VariousDriver {
	WebDriver driver;

	@Test
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		//driver = new ChromeDriver();
		
		
		driver.get("https://techfios.com/billing/?ng=admin/");
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);

	}

	//@Test
	public void Enrollment(){
		//Assert.assertEquals("Login page found", "Login - iBilling", driver.getTitle());

		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("demo@techfios.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("abc123");
		WebElement button = driver.findElement(By.name("login"));
		button.click();
		WebElement dashboard = driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=dashboard/']"));
		String page = dashboard.getText();
		
		//Assert.assertEquals("Not Found", "Dashboard", page);
		}

	//public void customerlink() {
		By customerL = (By) driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
		//customerl.click();
		//Thread.sleep(4000);
		//System.out.println(customerLink.getText());

		By add = By.xpath("//a[contains(text(),'Add Customer')]");

		//Thread.sleep(4000);
		By name = By.id("account");
				//;sendKeys("Nilima 
				//By companyName = By.id("cid");
		//Select sel = new Select(companyName);
		//sel.selectByVisibleText("Techfios");
		// driver.findElement(By.id("email")).sendKeys("demo2@techfios.com");
		// driver.findElement(By.name("phone")).sendKeys("(972)120-3450");
		By address = By.name("address");
		//sendKeys("123 Soeller");
		By city = By.name("city");
		//sendKeys("Coppell");
		By state  = By.name("state");
		//sendKeys("TX");
		By zip = By.name("zip");
		//sendKeys("76430");

	}

