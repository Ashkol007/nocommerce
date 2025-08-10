package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pageObjects.Admin.LoginPage;
import pageObjects.Frontend.RegisterPage;
import pageObjects.Frontend.RegisterResultPage;

public class Registersteps{
	
	WebDriver driver;
	WebDriverWait await;
	LoginPage lp;
	RegisterPage Rp;
	RegisterResultPage Rrp;
	
	@Before
	public void setup() {
		
		 ChromeOptions options = new ChromeOptions();


	        // Hide automation flag
	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        options.setExperimentalOption("useAutomationExtension", false);

	        // Use normal browser-like settings
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        options.addArguments("start-maximized");
	        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
	                + "AppleWebKit/537.36 (KHTML, like Gecko) "
	                + "Chrome/115.0.0.0 Safari/537.36");
		
		driver = new ChromeDriver(options);
          		
	}
	
	
	@Given("User is on the nopCommerce registration page URl {string}")
	public void user_is_on_the_nop_commerce_registration_page(String url) {
		driver.get(url);
	}

	@When("User enters first name, last name, email, password, and confirm password")
	public void user_enters_first_name_last_name_email_password_and_confirm_password() {
	    Rp = new RegisterPage(driver);
	    Rp.setEmail("ashitosh@gmail.com");
	    Rp.setFirstName("Ashitosh");
	    Rp.setLarstName("Kole");
	    Rp.setPassword("*Ashkol007");
	    Rp.setConfirmpwd("*Ashkol007");
	    
	}

	@When("User clicks the register button")
	public void user_clicks_the_register_button() {
		Rp.clickRegisterBtn();
	}

	@Then("User should see the registration confirmation message {string}")
	public void user_should_see_the_registration_confirmation_message(String string) {
        
		Rrp = new RegisterResultPage(driver);
		
		Assert.assertEquals(Rrp.isRegistrationSuccessMsg(), true);
        
		
	}
	
	
	
	
}