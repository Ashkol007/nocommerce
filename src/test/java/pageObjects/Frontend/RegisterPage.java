package pageObjects.Frontend;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	
	
	WebDriver driver;
	WebDriverWait await;
	
	public RegisterPage(WebDriver driver){
	   
		this.driver = driver;
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
		
	}
	
	

    By FirstNameInp = By.xpath("//input[@id='FirstName']");
    By LastNameInp =  By.xpath("//input[@id='LastName']");
    By EmailInp =  By.xpath("//input[@id='Email']");
    By PasswordInp = By.xpath("//input[@id='Password']");
    By ConfirmPwdInp = By.xpath("//input[@id='ConfirmPassword']");
    By RegisterBtn = By.xpath("//button[@id='register-button']");
	
	
	public void setFirstName(String fname) {

		await.until(ExpectedConditions.elementToBeClickable(FirstNameInp));
		driver.findElement(FirstNameInp).sendKeys(fname);;
	}
	
	public void setLarstName(String lname) {

		await.until(ExpectedConditions.elementToBeClickable(LastNameInp));
		driver.findElement(LastNameInp).sendKeys(lname);;
	}
	
	public void setEmail(String email) {

		await.until(ExpectedConditions.elementToBeClickable(EmailInp));
		driver.findElement(EmailInp).sendKeys(email);
	}
	
	public void setPassword(String pwd) {

		await.until(ExpectedConditions.elementToBeClickable(PasswordInp));
		driver.findElement(PasswordInp).sendKeys(pwd);
	}
	
	public void setConfirmpwd(String pwd) {

		await.until(ExpectedConditions.elementToBeClickable(ConfirmPwdInp));
		driver.findElement(ConfirmPwdInp).sendKeys(pwd);
	}
	
	public void clickRegisterBtn() {
		await.until(ExpectedConditions.elementToBeClickable(RegisterBtn));
		driver.findElement(RegisterBtn).click();
	}
	
	

}
