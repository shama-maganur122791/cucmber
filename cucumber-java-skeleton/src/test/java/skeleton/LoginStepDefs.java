package skeleton;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefs {
	WebDriver driver;
	
	@Given("^The url of the application$")
	public void the_url_of_the_application() throws Throwable {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}

	@When("^user enters (.*) as username$")
	public void user_enters_mercury_as_username(String username) throws Throwable {
	    driver.findElement(By.name("userName")).sendKeys(username);
	}

	@When("^user enters (.*) as password$")
	public void user_enters_mercury_as_password(String password) throws Throwable {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@When("^user clicks on submit$")
	public void user_clicks_on_submit() throws Throwable {
		driver.findElement(By.name("login")).click();
	}

	@Then("^user is (valid|in valid)$")
	public void user_is_valid(String result) throws Throwable {
	if(result.equals("valid"))
	 Assert.assertTrue(driver.getTitle().contains("Find"));
	else
	  Assert.assertTrue(driver.getTitle().contains("Sign"));
	}

}
