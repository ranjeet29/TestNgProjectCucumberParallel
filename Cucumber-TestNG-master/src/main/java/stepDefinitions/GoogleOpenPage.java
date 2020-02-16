package stepDefinitions;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;


import cucumber.api.Scenario;
import gherkin.formatter.model.Step;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleOpenPage{

	 WebDriver driver;
	 private  Scenario scenario;
	 public Step step;
	 
	
	 @Before
	 public void beforeTest(Scenario scenario){
		   this.scenario = scenario;
		   long threadId = Thread.currentThread().getId();
		    String processName = ManagementFactory.getRuntimeMXBean().getName();
		    System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
	 }

	
	 @Given("^user is open browser Page$")
	 public void user_already_on_login_page() throws MalformedURLException{
	 System.setProperty("webdriver.chrome.driver","/Users/i0803/driverAndJar/chromedriver");
	 driver = new ChromeDriver();
	   //DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
	   //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	   driver.get("https://www.google.com");
	   
	 }
	
	
	 @When("^title of google page$")
	 public void title_of_login_page_is_free_CRM() throws Exception{
	 String title = driver.getTitle();
	 System.out.println(title);
	 scenario.write("title of page :"+title);
	 Assert.assertEquals("Google", title);
	 Thread.sleep(5000);
	 }
	

	 @Then("^Close the browser of google$")
	 public void close_the_browser(){
		 driver.quit();
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
