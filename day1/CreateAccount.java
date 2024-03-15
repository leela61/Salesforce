package practice.day1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateAccount {
	public static void main(String[] args) throws InterruptedException {
		//To disable notifications
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Launch the browser
		
		ChromeDriver driver = new ChromeDriver(options);
      //Login to https://login.salesforce.com
		
		driver.get("https://login.salesforce.com");

		//To maximize the Browser
		driver.manage().window().maximize();
		
		//Add the implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username into UN field
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		//Enter the password to the PW field
		driver.findElement(By.id("password")).sendKeys("Qeagle@123");
		
		//click on login button
		driver.findElement(By.id("Login")).click();
		
		// 2. Click on toggle menu button from the left corner
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		//Add Thread.sleep
		Thread.sleep(30);
		
		//3. Click view All 
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		
		//4.click Sales from App Launcher
		driver.findElement(By.xpath("(//div[@class='slds-app-launcher__tile-body slds-truncate'])[2]")).click();
		
		//5.Click on Accounts tab 
		WebElement findElement = driver.findElement(By.xpath("//span[@class='slds-truncate']/parent::a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",findElement);
		
		//6.Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		//Add Thread.sleep
		Thread.sleep(30);
		
		//Enter 'your name' as account name
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).sendKeys("leela");
		Thread.sleep(3000);
		
		//Add the Actions class for (scroll the page)
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//input[@class='slds-input'])[14]"));
		action.scrollToElement(element).perform();
		
		//Select Ownership as Public         
	    driver.findElement(By.xpath("(//label[text()='Ownership']//following::button)[1]")).click();
	 
	    driver.findElement(By.xpath("//span[text()='Public']")).click();
	 
	 //Click save 
	 
	 driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[3]")).click();
	 
	 //verify Account name
	 String text = driver.findElement(By.xpath("//div[@class='toastContainer slds-notify_container slds-is-relative']")).getText();
	 System.out.println(text);

	    //To close the browser 
	    driver.close(); 
	 
	}
}