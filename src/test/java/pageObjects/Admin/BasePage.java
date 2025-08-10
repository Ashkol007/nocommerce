package pageObjects.Admin;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver ldriver;
	WebDriverWait await; 
	
	
	public BasePage(WebDriver rdriver){
        ldriver = rdriver;

    	await = new WebDriverWait(ldriver,Duration.ofSeconds(10));
        PageFactory.initElements(rdriver,this);
	}

}
