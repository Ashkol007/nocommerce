package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class steps {
	
	WebDriver driver;
	WebDriverWait await;
	LoginPage lp;
	AddCustomerPage acp;
	SearchCustomerPage scp;
	
	 public static boolean isAlertPresent(WebDriver driver) {
	        try {
	            driver.switchTo().alert();
	            return true;
	        } catch (NoAlertPresentException e) {
	            return false;
	        }
	    }
	 
	@Before
	public void setup() {
		driver = new ChromeDriver();
		scp = new SearchCustomerPage(driver);
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
//	    driver = new ChromeDriver();
	    lp = new LoginPage(driver);	
	}

	@When("User opens Url {string}")
	public void user_opens_url(String url) {
       driver.get(url);
	}

	@When("User enters Emails as {string} and Password as {string}")
	public void user_enters_emails_as_and_password_as(String email, String pwd) {
	    lp.setLoginInput(email);
	    lp.setPasswordInput(pwd);
	    
	}

	@When("Click on login")
	public void click_on_login() {
	    lp.SubmitBtn();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	   Assert.assertEquals(driver.getTitle(), title);
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() {
		lp.Logout();

//		await = new WebDriverWait(driver,Duration.ofSeconds(10));
	    if(isAlertPresent(driver)) driver.switchTo().alert().accept();
	    
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	
//	Add customer from customer page
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	      acp = new AddCustomerPage(driver); 
  		  acp.getPageTitle().equalsIgnoreCase("Dashboard / nopCommerce administration");
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		  acp.selectCustomerMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		acp.selectCustomerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	    acp.clickAddNewBtn();
	}

	@Then("User enter customer info")
	public void user_enter_customer_info() {
      acp.setEmail("ashitosh100@gmail.com");
      acp.setPassword("12345");
      acp.setFirstName("Ashitosh");
      acp.setLastName("Kole");
      acp.selectGender("male");
      acp.setCompanyName("Emergys");
      acp.selectTaxExempt();
      acp.selectNewsLetterOptions();
      acp.selectCustomerRole("Guests");
      acp.selectVendor();
      acp.selectActiveBox();
      acp.selectChangePassword();
      acp.commentInAdminBox("As far now todays testcase is completed");
      
        
	}

	@Then("click on Save button")
	public void click_on_save_button() {
		acp.clickSaveButton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String successMsg) {
		System.out.println(acp.confirmMessage());
	    Assert.assertEquals(successMsg.trim(), acp.confirmMessage().replace("×", "").trim());
	}
	
//	Search customer by EmailId 
	@When("Enter customer Email")
	public void enter_customer_email() {
		scp = new SearchCustomerPage(driver);
		scp.enterEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		scp.clickSeacrchBtn();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_searcg_table() {
		Assert.assertEquals("victoria_victoria@nopCommerce.com", scp.isEmailAvailable());
	}
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
            scp.setFirstName("victoria"); 
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		scp.setLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
          
       Assert.assertEquals(true,scp.isNameAvailable("victoria","terces"));
	}





}
