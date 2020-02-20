package stepDefinitions;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;


import cucumber.api.Scenario;
import gherkin.formatter.model.Step;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

	 WebDriver driver;
	 private  Scenario scenario;
	 public Step step;
	 public boolean headless=true;
	
	 @Before
	 public void beforeTest(Scenario scenario){
		   this.scenario = scenario;
		    String processName = ManagementFactory.getRuntimeMXBean().getName();
		    System.out.println("Started in thread:  in JVM: " + processName);
	 }

	
	 @Given("^Env Setup and User is already on Home Page$")
	 public void env_setup_and_user_is_already_on_home_page() throws MalformedURLException{
	 System.setProperty("webdriver.chrome.driver","chromedriver");
	 ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
		if (headless) {
			System.out.println("In Headless");
			options.addArguments("--headless");
			options.addArguments("window-size=1366x768");
			options.addArguments("--disable-extensions");
			options.addArguments("enable-automation");
			options.addArguments("--window-size=1364,786");
			options.addArguments("--no-sandbox");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
		}
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
	    // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	    driver.get("http://34.224.128.171/login");
	   
	 }
	
	
	@Then("^Validating Title and login application with username \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void validating_title_and_login_application_with_username_something_and_password_as_something(String username, String password) throws Exception {
		String title = driver.getTitle();
		System.out.println(title);
		scenario.write("title of page :" + title);
		Assert.assertEquals("Innovaccer", title);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[(text()='Innovaccer')]")).click();
		driver.findElement(By.xpath("//div[@id='email']//input")).sendKeys(username);
		driver.findElement(By.xpath("(//div[@id='password']//input)[1]")).sendKeys(password);
		driver.findElement(By.xpath("//form[@id='datashop-login-form']//button[@class='button large success end float-right'][contains(text(),'Sign in to continue')]")).click();
		Thread.sleep(2000);
	}
	

	
	 @After
	 public void tearDown(Scenario scenario) {
	/*	 if(scenario.isFailed()) {
			 try {
				 System.out.println(scenario.getName() + " is Failed");
			 	 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			 	 scenario.embed(screenshot, "image/png"); 
			 }catch (Exception e) {
				e.printStackTrace();
			}
	     }else {
	    	 try {
	    		 
	    		 System.out.println(scenario.getName() + " is Passed");
	    		 scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png" );
	    	 }catch (Exception e) {
				e.printStackTrace();
			}
	     }
           */
	    if(driver != null) {
	    	driver.quit();
	    	
	    }
	 }	

}
