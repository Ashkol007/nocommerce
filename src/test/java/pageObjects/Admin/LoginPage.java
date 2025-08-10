package pageObjects.Admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
	
public LoginPage(WebDriver rdriver) {
		super(rdriver);
		// TODO Auto-generated constructor stub
	}

//	WebDriver ldriver;
//	WebDriverWait await; 
//	
//	
//	public LoginPage(WebDriver rdriver){
//        ldriver = rdriver;
//
//    	await = new WebDriverWait(ldriver,Duration.ofSeconds(10));
//        PageFactory.initElements(rdriver,this);
//	}
	
	@FindBy(xpath="//input[@id='Email']") WebElement LoginInput;
	@FindBy(xpath="//input[@class='password']") WebElement PasswordInput;
	@FindBy(xpath="//button[@type='submit']") WebElement SubmitBtn;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement LogoutBtn;
	
	public void setLoginInput(String email) {
		LoginInput.clear();
		LoginInput.sendKeys(email);
	}
	
	public void setPasswordInput(String pwd) {
		PasswordInput.clear();
		PasswordInput.sendKeys(pwd);
	}
     
	public void SubmitBtn() {
		SubmitBtn.click();
	}
	
    public void Logout() {
        await.until(ExpectedConditions.visibilityOf(LogoutBtn)).click();
//    	LogoutBtn.click();
    }

}
