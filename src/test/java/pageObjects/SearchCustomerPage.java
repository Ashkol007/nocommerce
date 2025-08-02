package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchCustomerPage extends BasePage {

	public SearchCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']") @CacheLookup private WebElement emailInput;
	@FindBy(xpath="//button[@id='search-customers']") @CacheLookup private WebElement searchBtn;
	@FindBy(xpath="(//td[@class='text-center'])[1]/following-sibling::td[1]") @CacheLookup private WebElement emailCheckTab;
	@FindBy(css="#SearchFirstName") @CacheLookup private WebElement firstNameInp;
	@FindBy(css="#SearchLastName") @CacheLookup private WebElement lastNameInp;
	@FindBy(xpath="//table") WebElement table;
	@FindBy(xpath="//table//tbody//tr") List<WebElement> rows;
	
 
	
	public void enterEmail(String email) {
		
		emailInput.sendKeys(email);
	}
	
	public void clickSeacrchBtn() {
		await.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();
	}
	
	public String isEmailAvailable() {
        System.out.println(emailCheckTab.getText());
		await.until(ExpectedConditions.elementToBeClickable(emailCheckTab));
		return emailCheckTab.getText(); 	
	}
	
	public void setFirstName(String firstname) {

		await.until(ExpectedConditions.elementToBeClickable(firstNameInp));
		firstNameInp.sendKeys(firstname);
	}
	
	public void setLastName(String lastName) {

		await.until(ExpectedConditions.elementToBeClickable(lastNameInp));
		lastNameInp.sendKeys(lastName);
	}
	
	public Boolean isNameAvailable(String firstName, String lastName) {
		
		Boolean flag = false;
		
		for(int i=1;i<=rows.size();i++) {
			
			  String nameCol = table.findElement(By.xpath("//table//tbody//tr["+i+"]//td[3]")).getText();
			  
			  if(nameCol.trim().toLowerCase().contains(lastName.toLowerCase()) && nameCol.contains(firstName)) {
				  flag = true; 
			  }
			  
			  
		}
		
		return flag;
		
	}
	
	

}
