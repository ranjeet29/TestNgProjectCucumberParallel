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
	 public boolean headless=false;
	
	 @Before
	 public void beforeTest(Scenario scenario){
		   this.scenario = scenario;
		    String processName = ManagementFactory.getRuntimeMXBean().getName();
		    System.out.println("Started in thread:  in JVM: " + processName);
	 }

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page() throws MalformedURLException{
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
	  //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	   driver.get("http://34.224.128.171/login");
	   
	 }
	
	
	 @When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM() throws Exception{
	 String title = driver.getTitle();
	 System.out.println(title);
	 scenario.write("title of page :"+title);
	 Assert.assertEquals("Innovaccer", title);
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[(text()='Innovaccer')]")).click();
	 driver.findElement(By.xpath("//div[@id='email']//input")).sendKeys("care@innovaccer.com");
	 driver.findElement(By.xpath("(//div[@id='password']//input)[1]")).sendKeys("demo123");
	 driver.findElement(By.xpath("//form[@id='datashop-login-form']//button[@class='button large success end float-right'][contains(text(),'Sign in to continue')]")).click();
	 Thread.sleep(5000);
	 }
	

	
	 @After
	 public void tearDown(Scenario scenario) {
		 if(scenario.isFailed()) {
			 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			      scenario.embed(screenshot, "image/png");     
	     }
	    if(driver != null) {
	    	driver.quit();
	    	
	    }
	 }
	
	
    
	 
		public void afterTest(Scenario scenario) throws InterruptedException {
		    System.out.println("Taking screenshot IF Test Failed (sysOut)");
		    if (scenario.isFailed()) {
		        try {
		            System.out.println("Scenario FAILED... screen shot taken");
		            scenario.write(driver.getCurrentUrl());
		            byte[] screenShot = ((org.openqa.selenium.TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		            scenario.embed(screenShot, "image/png");
		        } catch (WebDriverException e) {
		            e.printStackTrace();
		        }
		    }else {
		    	scenario.write("title");
		    }
		} 
	

}
