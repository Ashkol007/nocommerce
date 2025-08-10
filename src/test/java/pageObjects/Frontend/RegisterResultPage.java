package pageObjects.Frontend;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterResultPage {
	
	WebDriver driver;
	WebDriverWait await;
	
	public RegisterResultPage(WebDriver driver) {
		
		this.driver = driver;
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements( driver,this);
		
	}
	
      
	@FindBy(xpath="//div[@class='result']") WebElement RegistrationCompletedMsg;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")WebElement ContinueBtn;
	
	public Boolean isRegistrationSuccessMsg() {
		
		await.until(ExpectedConditions.elementToBeClickable(RegistrationCompletedMsg));
           if(RegistrationCompletedMsg.isDisplayed()) return true;
           return false;
	}
	
	public void clickContinue() {

		await.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
	}
	
 

}
