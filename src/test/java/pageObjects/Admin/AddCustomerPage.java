package pageObjects.Admin;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage {

	public AddCustomerPage(WebDriver rdriver){
		super(rdriver);
	}
//	WebDriver ldriver;
//	WebDriverWait await;
//	
//	public AddCustomerPage(WebDriver rdriver){
//		ldriver = rdriver;
//		await = new WebDriverWait(ldriver,Duration.ofSeconds(10));
//		PageFactory.initElements( ldriver,this);
//		
//	}
	
	By customersMenu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customerMenuItem = By.xpath("(//p[contains(text(),'Customers')])[2]");
	
	By AddNewBtn = By.xpath("//a[normalize-space()='Add new']");
	By EmailInput = By.xpath("//input[@id='Email']");  
    By PasswordInput = By.xpath("//input[@id='Password']");
    By firstName      = By.xpath("//input[@id='FirstName']");
    By lastName       = By.xpath("//input[@id='LastName']");
    By genderMale     = By.xpath("//input[@id='Gender_Male']");
    By genderFemale   = By.xpath("//input[@id='Gender_Female']");
    By company        = By.xpath("//input[@id='Company']");
    By isTaxExempt    = By.xpath("//input[@id='IsTaxExempt']");
    
    By newsletter     = By.xpath("(//input[@role='searchbox'])[1]");
    By newsLetterList = By.xpath("(//ul[@id='select2-SelectedNewsletterSubscriptionStoreIds-results'])[1]");
    By newsLetterOption = By.xpath("//li[contains(text(),'nopCommerce admin demo store')]");
    
    
    By customerSearch = By.xpath("(//ul[@class='select2-selection__rendered'])[2]");
    By customerRoleList = By.cssSelector("#select2-SelectedCustomerRoleIds-results");
    By customerItemAdminstrators = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-uwfm-1']");
    By customerItemVendors = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-fkiq-5']");
    
    By vendorSelectDropdown = By.xpath("//select[@id='VendorId']");
    
    By activeCheckbox = By.xpath("//input[@id='Active']");
    By changePasswordCheckbox = By.xpath("//input[@id='MustChangePassword']");
    By adminComment   = By.xpath("//textarea[@id='AdminComment']");
 
    By saveBtn = By.xpath("//button[@name='save']");
    By confirmMessage = By.xpath("//div[@class='alert alert-success alert-dismissable']");
    
    public void selectCustomerMenu() {
    	await.until(ExpectedConditions.presenceOfElementLocated(customersMenu));
    	ldriver.findElement(customersMenu).click();
    }
    
    public void selectCustomerMenuItem() {
//    	await.until(ExpectedConditions.presenceOfElementLocated(customerMenuItem));
    	WebElement customerMenuWeb = ldriver.findElement(customerMenuItem);
    	
    	JavascriptExecutor js = (JavascriptExecutor) ldriver;
    	js.executeScript("arguments[0].click()", customerMenuWeb);
    }
    
    public void clickAddNewBtn() {
    	ldriver.findElement(AddNewBtn).click();
    }
    
    public void setEmail(String email) {
    	ldriver.findElement(EmailInput).sendKeys(email);
    }
    
    public void setPassword(String pwd) {
    	ldriver.findElement(PasswordInput).sendKeys(pwd);
    }
    
    public void setFirstName(String FirstName) {
    	ldriver.findElement(firstName).sendKeys(FirstName);
    }
    
    public void setLastName(String LastName) {
    	ldriver.findElement(lastName).sendKeys(LastName);
    	
    }
    
    public void selectGender(String gender) {
    	if(gender.equalsIgnoreCase("male")) {
    		ldriver.findElement(genderMale).click();
    	}else {
    		ldriver.findElement(genderFemale).click();
    	}
    }
    
    public void setCompanyName(String companyName) {
    	
    	ldriver.findElement(company).sendKeys(companyName);
    }
    
    
    public void selectTaxExempt() {
    	ldriver.findElement(isTaxExempt).click();
    }
    
    public void selectNewsLetterOptions() {
    	
    	
    	ldriver.findElement(newsletter).click();
    	await.until(ExpectedConditions.elementToBeClickable(newsLetterList));
    	
        ldriver.findElement(newsLetterOption).click();
    	List<WebElement> options =   ldriver.findElements(newsLetterList);
    	
    	for(WebElement opt : options ) {
    		
    		if(opt.getText().equalsIgnoreCase("nopCommerce admin demo store")) {
    			opt.click();
    		}
    		
 	   }
    	
    }
    
    public void selectCustomerRole(String role) {
    	
    	ldriver.findElement(customerSearch);
    	
//    	await.until(ExpectedConditions.presenceOfElementLocated(customerRoleList));
    	
    	List<WebElement> customerOptions =  ldriver.findElements(customerRoleList);
    	
//    	WebElement administrator = ldriver.findElement(customerItemAdminstrators);
    	
    	for(WebElement opt : customerOptions) {
    		
    		if(opt.getText().equalsIgnoreCase(role)) {
    			opt.click();
    		}
    	}
    	
    }
    
    public void selectVendor() {
    	
    	WebElement  vendorinput = ldriver.findElement(vendorSelectDropdown);
    	
    	vendorinput.click();
    	
    	Select vendorOptions = new Select(vendorinput);
    	       vendorOptions.selectByValue("1");
    	
    }
    
    
    public void selectActiveBox() {
    	
    	ldriver.findElement(activeCheckbox).click();
    	
    }
    
    public void selectChangePassword() {
    	ldriver.findElement(changePasswordCheckbox).click();
    }
    
    public void commentInAdminBox(String comment) {
    	
    	ldriver.findElement(adminComment).sendKeys(comment);
    }
    
    
    public String getPageTitle() {
    	return ldriver.getTitle();
    }
    
    public void clickSaveButton() {
    	ldriver.findElement(saveBtn).click();
    }
    
    public String confirmMessage() {
    	String confMessage = ldriver.findElement(confirmMessage).getText();
        return confMessage;
    }
    
    
    
    
    
    


	
	
}
