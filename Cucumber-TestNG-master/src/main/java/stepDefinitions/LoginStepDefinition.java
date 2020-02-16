package stepDefinitions;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import gherkin.formatter.model.Step;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition{

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

	
	 @Given("^user is already on Login Page$")
	 public void user_already_on_login_page() throws MalformedURLException{
	 System.setProperty("webdriver.chrome.driver","chromedriver");
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
     options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
     options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
     options.addArguments("--headless");
     options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
     options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
     options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
     options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
     driver = new ChromeDriver(options);

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
	

	 @Then("^Close the browser$")
	 public void close_the_browser(){
		 driver.quit();
	 }
	
	
	 @After
	 public void tearDown() {
		 if (scenario.isFailed()) {
		      // Take a screenshot...
		      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
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
