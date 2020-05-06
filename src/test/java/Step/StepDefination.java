package Step;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.Lib;

public class StepDefination extends Lib {

	public WebDriver driver;

	@Before
	public void initialize() {
		System.out.println("We start testing");
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\BDD_NEW\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30L, TimeUnit.SECONDS);
	}

	@Given("^user at facebook home page$")
	public void firststep() throws InterruptedException {
//		System.out.println(driver.getTitle());
		System.out.println("First Step");
		Thread.sleep(2000);
	}

	@When("^user enter username \"([^\"]*)\"$")
	public void secondstep(String username) throws Throwable {
		driver.findElement(By.xpath(readproperties(driver, "emailbox"))).sendKeys(username);
		
		}

	@And("^user enter password \"([^\"]*)\"$")
	public void thridstep(String password) throws InterruptedException, IOException{
		driver.findElement(By.xpath(readproperties(driver, "passwordbox"))).sendKeys(password);
		Thread.sleep(2000);
	}
	
	
	@And("^user click in login button")
	
	public void loginclick() throws Exception{
	driver.findElement(By.xpath(readproperties(driver, "loginbutton"))).click();
	Thread.sleep(2000);
	}
	
	@Then("^user see error message \"([^\"]*)\" \"([^\"]*)\"$" )
	public void errormessage(String expectederror, String key )throws Throwable {
		String actualerror=driver.findElement(By.xpath(key)).getText();
		String expectederrormsg="The password you’ve entered is incorrect. Forgot Password?";
		takescreenshot(driver, "9091");
		
		
		if(actualerror.equalsIgnoreCase(expectederrormsg)){
		
			System.out.println("Test is PASSED");
				}
		else{
			System.out.println("Test is FAILED");
		}
	}
	
	@After
	public void teardown(){
		System.out.println("We finished testing");
driver.manage().deleteAllCookies();		
driver.close();
	}
	
}
